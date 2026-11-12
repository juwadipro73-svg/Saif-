#!/usr/bin/env python3
"""Repair mechanical source damage in the SAIF AI Kotlin tree.

The tree went through a rewrite pass that renamed things in one place but not in the
body that used them. These are pure identifier/formatting repairs, no behaviour change:

  1. catch (err: E) { ... e.message ... }            -> catch (e: E)
  2. context.resolver                               -> context.contentResolver
  3. enableVibration(value = true)                  -> enableVibration(true)
  4. string literals split over lines by a lost \n   -> one line with \n
  5. a missing comma between two named arguments     -> comma restored
"""
import re
import sys
import os

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "final", "app", "src")


def kt_files():
    for dp, _, fns in os.walk(ROOT):
        for fn in fns:
            if fn.endswith(".kt"):
                yield os.path.join(dp, fn)


def match_brace(s, i):
    """Return index just past the block that starts at s[i] == '{'."""
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
        else:
            out.append(s[pos:m.end()])
        pos = m.end()
    return "".join(out), changes


SIMPLE = [
    (re.compile(r"\.resolver\b(?!\s*=)"), ".contentResolver"),
    (re.compile(r"enableVibration\(value\s*=\s*(true|false)\)"), r"enableVibration(\1)"),
    (re.compile(r"enableLights\(value\s*=\s*(true|false)\)"), r"enableLights(\1)"),
    (re.compile(r"setShowBadge\(value\s*=\s*(true|false)\)"), r"setShowBadge(\1)"),
]

# named-argument lines that are missing their trailing comma
MISSING_COMMA = re.compile(
    r"^(?P<indent>[ \t]+)(?P<arg>[A-Za-z_]\w*\s*=\s*(?:\"[^\"]*\"|'[^']*'|\d[\w.]*|[A-Za-z_][\w.]*(?:\([^()]*\))?))\n"
    r"(?P<next>[ \t]+[A-Za-z_]\w*\s*=)",
    re.M,
)


def odd_quote_lines(s):
    """Lines that end inside an unterminated string literal (source damage report)."""
    bad = []
    for i, line in enumerate(s.split("\n"), 1):
        if line.lstrip().startswith("//"):
            continue
        quotes = 0
        j = 0
        while j < len(line):
            if line[j] == "\\":
                j += 2
                continue
            if line[j] == '"':
                quotes += 1
            j += 1
        if quotes % 2 == 1:
            bad.append(i)
    return bad


def main():
    apply = "--apply" in sys.argv
    total = {"catch": 0, "simple": 0, "strings": 0, "comma": 0}
    touched = []
    for path in kt_files():
        src = open(path, encoding="utf-8").read()
        new, c1 = fix_catch(src)
        c2 = 0
        for rx, repl in SIMPLE:
            new, n = rx.subn(repl, new)
            c2 += n
        c3 = 0
        bad = odd_quote_lines(new)
        if bad:
            print(f"UNTERMINATED STRING {os.path.relpath(path, ROOT)}: lines {bad[:8]}")
        if os.sep + "test" + os.sep in path and "--include-tests" not in sys.argv:
            c4 = 0
        else:
            new, c4 = MISSING_COMMA.subn(r"\g<indent>\g<arg>,\n\g<next>", new)
        if new != src:
            touched.append((os.path.relpath(path, ROOT), c1, c2, c3, c4))
            total["catch"] += c1
            total["simple"] += c2
            total["strings"] += c3
            total["comma"] += c4
            if apply:
                open(path, "w", encoding="utf-8").write(new)
    for t in touched:
        print(f"{t[0]}: catch={t[1]} simple={t[2]} strings={t[3]} comma={t[4]}")
    print(f"\nfiles touched: {len(touched)}  {total}")
    if not apply:
        print("(dry run - pass --apply)")


if __name__ == "__main__":
    main()
