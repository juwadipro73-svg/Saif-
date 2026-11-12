#!/usr/bin/env python3
"""Locally detect and repair Kotlin syntax damage using tree-sitter.

The rewrite pass left mechanical damage (lost or extra commas, stray brackets, split
statements). The Kotlin compiler reports one cascading error per site which is slow to
iterate on in CI, so this tool parses every file locally, proposes small repairs around
each ERROR node and keeps an edit only when it strictly reduces the number of errors.

Usage:
  syntax_fix.py            # report only
  syntax_fix.py --apply    # apply repairs
  syntax_fix.py --file X   # single file
"""
import os
import re
import sys

import tree_sitter as ts
import tree_sitter_kotlin as tsk

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "final", "app", "src")
PARSER = ts.Parser(ts.Language(tsk.language()))


def parse(src: bytes):
    return PARSER.parse(src)


def errors_of(tree):
    acc = []

    def walk(n):
        if n.type == "ERROR" or n.is_missing:
            acc.append(n)
        for c in n.children:
            walk(c)

    walk(tree.root_node)
    return acc


def error_count(src: bytes) -> int:
    return len(errors_of(parse(src)))


def kt_files(only=None):
    out = []
    for dp, _, fns in os.walk(ROOT):
        for fn in fns:
            if fn.endswith(".kt"):
                p = os.path.join(dp, fn)
                if only and os.path.abspath(p) != os.path.abspath(only):
                    continue
                out.append(p)
    return sorted(out)


def candidates(src: bytes, err):
    """Yield (label, new_src) repairs around one error node."""
    text = src.decode("utf-8")
    lines = text.split("\n")
    start_line = err.start_point[0]
    end_line = err.end_point[0]
    lo = max(0, start_line - 3)
    hi = min(len(lines) - 1, end_line + 3)

    def with_lines(new_lines, label):
        return label, "\n".join(new_lines).encode("utf-8")

    for i in range(lo, hi + 1):
        line = lines[i]
        # 1. drop a trailing comma that turned a statement into an argument
        if line.rstrip().endswith(","):
            copy = lines[:]
            copy[i] = line.rstrip()[:-1]
            yield with_lines(copy, f"drop comma line {i + 1}")
        # 2. add a missing comma at end of line
        if line.strip() and not line.rstrip().endswith((",", "(", "{", "[")):
            nxt = lines[i + 1] if i + 1 < len(lines) else ""
            if re.match(r"^\s*[A-Za-z_]\w*\s*=", nxt):
                copy = lines[:]
                copy[i] = line.rstrip() + ","
                yield with_lines(copy, f"add comma line {i + 1}")
        # 3. join a split statement:  "x ="  +  "  y"   -> "x = y"
        if line.rstrip().endswith(("=", "+", "&&", "||", "(", "->")) and i + 1 < len(lines):
            copy = lines[:]
            joined = line.rstrip() + " " + lines[i + 1].strip()
            copy[i] = joined
            del copy[i + 1]
            yield with_lines(copy, f"join line {i + 1}")
        # 4. remove one stray closing bracket at the end of the line
        stripped = line.rstrip()
        if stripped.endswith(")") and stripped.count(")") > stripped.count("("):
            copy = lines[:]
            copy[i] = stripped[:-1]
            yield with_lines(copy, f"drop ')' line {i + 1}")
        if stripped.endswith("}") and stripped.count("}") > stripped.count("{"):
            copy = lines[:]
            copy[i] = stripped[:-1]
            yield with_lines(copy, f"drop '}}' line {i + 1}")

    # 5. delete the offending line entirely when it is a lone token
    for i in range(lo, hi + 1):
        if lines[i].strip() in (",", ")", "}", "{", "(", ";"):
            copy = lines[:]
            del copy[i]
            yield with_lines(copy, f"delete lone token line {i + 1}")


def repair_file(path: str, apply: bool) -> tuple[int, int]:
    raw = open(path, "rb").read()
    src = raw
    start_errors = error_count(src)
    if start_errors == 0:
        return 0, 0
    cur = start_errors
    log = []
    for _ in range(240):
        errs = errors_of(parse(src))
        if not errs:
            break
        best = None
        for err in errs[:3]:
            for label, cand in candidates(src, err):
                n = error_count(cand)
                if n < cur:
                    best = (n, label, cand)
                    break
            if best:
                break
        if not best:
            break
        cur, label, src = best
        log.append(label)
    if apply and cur < start_errors:
        open(path, "wb").write(src)
    return start_errors, cur


def main():
    apply = "--apply" in sys.argv
    only = None
    if "--file" in sys.argv:
        only = sys.argv[sys.argv.index("--file") + 1]
    total_before = total_after = bad_files = 0
    for path in kt_files(only):
        before, after = repair_file(path, apply)
        if before:
            bad_files += 1
            total_before += before
            total_after += after
            status = "OK" if after == 0 else f"{after} left"
            print(f"{os.path.relpath(path, ROOT)}: {before} -> {status}")
    print(f"\nfiles with syntax errors: {bad_files}  errors: {total_before} -> {total_after}"
          + ("" if apply else "  (dry run)"))


if __name__ == "__main__":
    main()
