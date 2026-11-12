#!/usr/bin/env python3
"""Static index of the SAIF AI Kotlin sources.

Finds (a) imports of project-internal symbols that no file declares and
(b) project-internal packages that are referenced but never declared.
This is a fast pre-filter; the Kotlin compiler in CI is the real judge.
"""
import os
import re
import sys
from collections import defaultdict

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..")
SRC_DIRS = [
    os.path.join(ROOT, "final/app/src/main/java"),
    os.path.join(ROOT, "final/app/src/standard/java"),
    os.path.join(ROOT, "final/app/src/termux/java"),
]

DECL_RE = re.compile(
    r"^\s*(?:@\w+(?:\([^)]*\))?\s*)*"
    r"(?:(?:public|private|internal|protected|open|abstract|sealed|data|enum|annotation|value|inner|inline|expect|actual|"
    r"const|lateinit|override|suspend|operator|infix|tailrec|external|companion|fun|val|var)\s+)*"
    r"(class|interface|object|typealias)\s+([A-Za-z_]\w*)"
)
TOP_FUN_RE = re.compile(r"^\s*(?:(?:public|private|internal|suspend|inline|operator|infix|tailrec|external|override)\s+)*fun\s+(?:<[^>]*>\s*)?(?:[A-Za-z_][\w.<>?, ]*\.)?([A-Za-z_]\w*)\s*\(")
TOP_VAL_RE = re.compile(r"^\s*(?:(?:public|private|internal|const|lateinit|override)\s+)*(?:val|var)\s+([A-Za-z_]\w*)")
PKG_RE = re.compile(r"^\s*package\s+([\w.]+)")
IMPORT_RE = re.compile(r"^\s*import\s+([\w.]+)(?:\.\*)?(?:\s+as\s+(\w+))?\s*$")


def source_files(base, extra=None):
    out = []
    for d in SRC_DIRS:
        for dp, _, fns in os.walk(d):
            for fn in fns:
                if fn.endswith(".kt"):
                    out.append(os.path.join(dp, fn))
    return sorted(set(out))


def strip_comments(text):
    text = re.sub(r"/\*.*?\*/", "", text, flags=re.S)
    text = re.sub(r"//[^\n]*", "", text)
    return text


def main():
    decls = defaultdict(set)          # fqn -> files
    packages = set()
    file_imports = []
    per_file_decls = {}
    for path in source_files(None):
        raw = open(path, encoding="utf-8", errors="replace").read()
        txt = strip_comments(raw)
        pkg = ""
        names = set()
        for line in txt.splitlines():
            m = PKG_RE.match(line)
            if m and not pkg:
                pkg = m.group(1)
                packages.add(pkg)
                continue
            m = IMPORT_RE.match(line)
            if m:
                file_imports.append((path, m.group(1), pkg))
                continue
            m = DECL_RE.match(line)
            if m:
                names.add(m.group(2))
            else:
                m = TOP_FUN_RE.match(line)
                if m:
                    names.add(m.group(1))
                else:
                    m = TOP_VAL_RE.match(line)
                    if m:
                        names.add(m.group(1))
        per_file_decls[path] = (pkg, names)
        for n in names:
            decls[f"{pkg}.{n}" if pkg else n].add(path)

    own_prefixes = ("com.example", "com.saifai", "saif.")
    missing = defaultdict(list)
    for path, imp, pkg in file_imports:
        if not imp.startswith(own_prefixes):
            continue
        if imp in decls:
            continue
        # member import: com.example.Foo.bar  -> com.example.Foo
        parts = imp.split(".")
        ok = False
        for i in range(len(parts) - 1, 1, -1):
            if ".".join(parts[:i]) in decls:
                ok = True
                break
        if not ok:
            missing[imp].append(os.path.relpath(path, ROOT))

    print(f"files: {sum(len(v) for k, v in [('.', per_file_decls)] ) if False else len(per_file_decls)}")
    print(f"declared symbols: {len(decls)}  packages: {len(packages)}")
    print(f"\nunresolved project imports: {len(missing)}")
    for imp in sorted(missing):
        print(f"  {imp}  ({len(missing[imp])}: {', '.join(os.path.basename(p) for p in missing[imp][:4])})")
    return 0


if __name__ == "__main__":
    sys.exit(main())
