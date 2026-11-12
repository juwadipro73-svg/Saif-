#!/usr/bin/env python3
"""Repair the mechanical source damage left by the earlier one-line-at-a-time rewrite.

Every rule here is a pure formatting/identifier repair; no behaviour is invented.
Rules are idempotent and only fire on the exact damaged text.

  1. `catch (err: E) { ... e.message ... }`  -> parameter renamed to `e` when the body used it
  2. `context.resolver`                      -> `context.contentResolver`
  3. `enableVibration(value = true)`         -> positional argument
  4. missing comma between named arguments   -> restored, but ONLY inside an argument list
                                                 (paren depth greater than brace depth)
  5. stray `}` at end of file                -> removed when the file over-closes
  6. known broken string literals            -> repaired one by one
"""
import os
import re
import sys

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "final", "app", "src")


def kt_files():
    for dp, _, fns in os.walk(ROOT):
        for fn in fns:
            if fn.endswith(".kt"):
                yield os.path.join(dp, fn)


def match_brace(s, i):
    depth = 0
    n = len(s)
    while i < n:
        c = s[i]
        if c == '"':
            i += 1
            while i < n and s[i] != '"':
                if s[i] == '\\':
                    i += 1
                i += 1
        elif c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
            if depth == 0:
                return i + 1
        i += 1
    return n


CATCH = re.compile(r"catch\s*\(\s*(\w+)\s*:\s*")


def fix_catch(s):
    out = []
    pos = 0
    changes = 0
    while True:
        m = CATCH.search(s, pos)
        if not m:
            out.append(s[pos:])
            break
        name = m.group(1)
        if name == "e":
            out.append(s[pos:m.end()])
            pos = m.end()
            continue
        brace = s.find("{", m.end())
        if brace < 0:
            out.append(s[pos:m.end()])
            pos = m.end()
            continue
        end = match_brace(s, brace)
        body = s[brace:end]
        uses_name = re.search(r"\b" + re.escape(name) + r"\b", body)
        uses_e = re.search(r"\be\b", body)
        if uses_e and not uses_name:
            out.append(s[pos:m.start(1)] + "e")
            pos = m.end(1)
            changes += 1
            continue
        out.append(s[pos:m.end()])
        pos = m.end()
    return "".join(out), changes


SIMPLE = [
    (re.compile(r"\.resolver\b(?!\s*=)"), ".contentResolver"),
    (re.compile(r"enableVibration\(value\s*=\s*(true|false)\)"), r"enableVibration(\1)"),
    (re.compile(r"enableLights\(value\s*=\s*(true|false)\)"), r"enableLights(\1)"),
    (re.compile(r"setShowBadge\(value\s*=\s*(true|false)\)"), r"setShowBadge(\1)"),
]

NAMED_LINE = re.compile(r"^\s*[A-Za-z_]\w*\s*=\s*.+$")


def context_at_line_starts(s):
    """For each line, the top of the bracket stack at that line start ('P' call args, 'B' block)."""
    out = [""]
    stack = []
    i = 0
    n = len(s)
    while i < n:
        c = s[i]
        if c == "\n":
            i += 1
            out.append(stack[-1] if stack else "")
            continue
        if c == "/" and i + 1 < n and s[i + 1] == "/":
            j = s.find("\n", i)
            i = n if j < 0 else j
            continue
        if c == "/" and i + 1 < n and s[i + 1] == "*":
            j = s.find("*/", i + 2)
            i = n if j < 0 else j + 2
            continue
        if s[i:i + 3] == '"""':
            j = s.find('"""', i + 3)
            i = n if j < 0 else j + 3
            continue
        if c == '"':
            i += 1
            while i < n and s[i] != '"':
                if s[i] == "\\":
                    i += 1
                i += 1
            i += 1
            continue
        if c == "'":
            i += 1
            while i < n and s[i] != "'":
                if s[i] == "\\":
                    i += 1
                i += 1
            i += 1
            continue
        if c == "(":
            stack.append("P")
        elif c == "[":
            stack.append("I")
        elif c == "{":
            stack.append("B")
        elif c == ")":
            while stack and stack[-1] not in ("P",):
                stack.pop()
            if stack:
                stack.pop()
        elif c == "]":
            while stack and stack[-1] not in ("I", "P"):
                stack.pop()
            if stack:
                stack.pop()
        elif c == "}":
            while stack and stack[-1] != "B":
                stack.pop()
            if stack:
                stack.pop()
        i += 1
    return out


STATEMENT_ASSIGN = re.compile(
    r"^\s*(?:val|var|return|=)?\s*[A-Za-z_]\w*(?:\.[A-Za-z_]\w*|\[[^\]]*\])*\s*=\s*.+$"
)


def fix_statement_comma(s):
    """Drop a comma that was appended to an assignment statement inside a block."""
    contexts = context_at_line_starts(s)
    lines = s.split("\n")
    out = []
    changes = 0
    for idx, line in enumerate(lines):
        stripped = line.rstrip()
        if (
            stripped.endswith(",")
            and idx < len(contexts)
            and contexts[idx] in ("B", "")
            and STATEMENT_ASSIGN.match(stripped[:-1])
            and not stripped.lstrip().startswith("//")
        ):
            out.append(stripped[:-1])
            changes += 1
        else:
            out.append(line)
    return "\n".join(out), changes


ARG_VALUE = r'(?:"[^"]*"|\'[^\']*\'|[\d.]+[fFlL]?|true|false|null|[A-Za-z_][\w.]*(?:\([^()]*\))?)'


def fix_missing_comma(s):
    """Insert a comma between two named arguments of the same call."""
    contexts = context_at_line_starts(s)
    lines = s.split("\n")
    out = []
    changes = 0
    for idx, line in enumerate(lines):
        out.append(line)
        if idx + 1 >= len(lines):
            continue
        if idx < len(contexts) and not line.endswith(",") and contexts[idx] == "P":
            nxt = lines[idx + 1]
            cur = line.strip()
            if (
                re.match(r"^[A-Za-z_]\w*\s*=\s*" + ARG_VALUE + r"$", cur)
                and re.match(r"^[A-Za-z_]\w*\s*=", nxt.strip())
                and line.rstrip() == line
            ):
                out[-1] = line + ","
                changes += 1
    return "\n".join(out), changes


def fix_trailing_brace(s):
    """Drop an extra closing brace at end of file when the file over-closes."""
    depth = 0
    i = 0
    n = len(s)
    while i < n:
        c = s[i]
        if c == "/" and i + 1 < n and s[i + 1] == "/":
            j = s.find("\n", i)
            i = n if j < 0 else j
            continue
        if c == "/" and i + 1 < n and s[i + 1] == "*":
            j = s.find("*/", i + 2)
            i = n if j < 0 else j + 2
            continue
        if s[i:i + 3] == '"""':
            j = s.find('"""', i + 3)
            i = n if j < 0 else j + 3
            continue
        if c == '"':
            i += 1
            while i < n and s[i] != '"':
                if s[i] == "\\":
                    i += 1
                i += 1
            i += 1
            continue
        if c == "'":
            i += 1
            while i < n and s[i] != "'":
                if s[i] == "\\":
                    i += 1
                i += 1
            i += 1
            continue
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
        i += 1
    if depth == -1:
        stripped = s.rstrip()
        if stripped.endswith("}"):
            return stripped[:-1].rstrip() + "\n", 1
    return s, 0


EXACT_REPAIRS = [
    # HTTP responses that lost their escape sequences
    (
        'final/app/src/main/java/com/saifai/bridge/SaifLocalBridgeServer.kt',
        '            serverSocket = s,\n',
        '            serverSocket = s\n',
    ),
    (
        'final/app/src/main/java/com/saifai/bridge/SaifLocalBridgeServer.kt',
        '''                        val header = "HTTP/1.1 200 OK
" +
                                "Content-Type: ${entry.mimeType}
" +
                                "Content-Length: $length
" +
                                "Content-Disposition: attachment; filename="${entry.fileName}"
" +
                                "Connection: close

"
''',
        '''                        val header = "HTTP/1.1 200 OK\\r\\n" +
                                "Content-Type: ${entry.mimeType}\\r\\n" +
                                "Content-Length: $length\\r\\n" +
                                "Content-Disposition: attachment; filename=\\"${entry.fileName}\\"\\r\\n" +
                                "Connection: close\\r\\n\\r\\n"
''',
    ),
    (
        'final/app/src/main/java/com/saifai/bridge/SaifLocalBridgeServer.kt',
        '''                val notFound = "HTTP/1.1 404 Not Found
Content-Length: 0
Connection: close

"
''',
        '''                val notFound = "HTTP/1.1 404 Not Found\\r\\nContent-Length: 0\\r\\nConnection: close\\r\\n\\r\\n"
''',
    ),
    # Skill package text that lost its newline escapes
    (
        'final/app/src/main/java/com/saifai/skills/SaifSkillsEngine.kt',
        '"\nSource: "',
        '"\\nSource: "',
    ),
    (
        'final/app/src/main/java/com/saifai/skills/SaifSkillsEngine.kt',
        '"\n\n"',
        '"\\n\\n"',
    ),
    (
        'final/app/src/main/java/com/saifai/skills/SaifSkillsEngine.kt',
        'sb.append("\n--- BEGIN FILE: ").append(relPath).append(" ---\n")',
        'sb.append("\\n--- BEGIN FILE: ").append(relPath).append(" ---\\n")',
    ),
    (
        'final/app/src/main/java/com/saifai/skills/SaifSkillsEngine.kt',
        'sb.append("\n--- END FILE: ").append(relPath).append(" ---\n")',
        'sb.append("\\n--- END FILE: ").append(relPath).append(" ---\\n")',
    ),
    (
        'final/app/src/main/java/com/saifai/browser/SaifResearchBrowserView.kt',
        'progressVal = newProgress / 100f',
        'progressVal = progressValue / 100f',
    ),
    (
        'final/app/src/main/java/com/saifai/engine/SaifMcpServerHub.kt',
        '} catch (err: Throwable) {\n            "Tool execution exception: ${t.localizedMessage}"',
        '} catch (t: Throwable) {\n            "Tool execution exception: ${t.localizedMessage}"',
    ),
]


def main():
    apply = "--apply" in sys.argv
    totals = {"catch": 0, "simple": 0, "comma": 0, "brace": 0, "exact": 0, "stmt_comma": 0}
    for path in kt_files():
        src = open(path, encoding="utf-8").read()
        new, c1 = fix_catch(src)
        c2 = 0
        for rx, repl in SIMPLE:
            new, n = rx.subn(repl, new)
            c2 += n
        c3 = c7 = 0
        if "--commas" in sys.argv:
            new, c3 = fix_missing_comma(new)
            new, c7 = fix_statement_comma(new)
        totals["stmt_comma"] += c7
        new, c6 = fix_trailing_brace(new)
        if new != src:
            totals["catch"] += c1
            totals["simple"] += c2
            totals["comma"] += c3
            totals["brace"] += c6
            if apply:
                open(path, "w", encoding="utf-8").write(new)
    for rel, old, new in EXACT_REPAIRS:
        path = os.path.join(ROOT, "..", "..", "..", rel)
        path = os.path.normpath(path)
        if not os.path.exists(path):
            path = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", rel)
        text = open(path, encoding="utf-8").read()
        if old in text:
            totals["exact"] += 1
            if apply:
                open(path, "w", encoding="utf-8").write(text.replace(old, new, 1))
    print(totals, "(applied)" if apply else "(dry run)")


if __name__ == "__main__":
    main()
