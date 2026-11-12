/**
 * SAIF AI - Autonomous Tool Harness & Virtual Execution Sandbox
 */
class ToolHarness {
  constructor(fs) {
    this.fs = fs || window.workspaceFS;
    this.tools = {};
    this.registerStandardTools();
  }

  registerTool(name, description, schema, handler) {
    this.tools[name] = { name, description, schema, handler };
  }

  registerStandardTools() {
    // 1. Read File Tool
    this.registerTool(
      'read_file',
      'Read the contents of a file from the active workspace.',
      { path: 'string' },
      async ({ path }) => {
        const res = this.fs.readFile(path);
        if (res.success) {
          return { status: 'success', content: res.content };
        }
        return { status: 'error', error: res.error };
      }
    );

    // 2. Write File Tool
    this.registerTool(
      'write_file',
      'Create or overwrite a file with given contents in the workspace.',
      { path: 'string', content: 'string' },
      async ({ path, content }) => {
        const res = this.fs.writeFile(path, content);
        if (res.success) {
          return { status: 'success', message: `Saved ${path} (${res.bytes} bytes)` };
        }
        return { status: 'error', error: res.error };
      }
    );

    // 3. Patch / Edit File Tool
    this.registerTool(
      'edit_file',
      'Replace an exact substring within a workspace file.',
      { path: 'string', target: 'string', replacement: 'string' },
      async ({ path, target, replacement }) => {
        const res = this.fs.patchFile(path, target, replacement);
        if (res.success) {
          return { status: 'success', message: `Successfully edited ${path}` };
        }
        return { status: 'error', error: res.error };
      }
    );

    // 4. List Files Tool
    this.registerTool(
      'list_files',
      'List all current files in the workspace with metadata.',
      {},
      async () => {
        const files = this.fs.listFiles();
        return { status: 'success', files };
      }
    );

    // 5. Diagnostics Tool
    this.registerTool(
      'diagnostics',
      'Run syntax diagnostics and linting across workspace files.',
      { path: 'string' },
      async ({ path }) => {
        const filesToCheck = path ? [path] : Object.keys(this.fs.files);
        const results = [];

        for (const file of filesToCheck) {
          const res = this.fs.readFile(file);
          if (!res.success) continue;
          const code = res.content;
          const issues = [];

          // Bracket & syntax balance check
          const brackets = { '(': ')', '{': '}', '[': ']' };
          const stack = [];
          for (let i = 0; i < code.length; i++) {
            const ch = code[i];
            if (ch in brackets) stack.push(ch);
            else if (Object.values(brackets).includes(ch)) {
              const last = stack.pop();
              if (!last || brackets[last] !== ch) {
                issues.push(`Mismatched bracket '${ch}' near character index ${i}`);
                break;
              }
            }
          }
          if (stack.length > 0) {
            issues.push(`Unclosed bracket '${stack[stack.length - 1]}'`);
          }

          results.push({
            file,
            valid: issues.length === 0,
            issues: issues.length ? issues : ['No syntax issues found.']
          });
        }

        return { status: 'success', results };
      }
    );

    // 6. Shell & Code Execution Tool
    this.registerTool(
      'shell_exec',
      'Execute a shell command or run a Python/JavaScript script in virtual sandbox.',
      { command: 'string' },
      async ({ command }) => {
        return this.executeShell(command);
      }
    );

    // 7. Web Fetch Tool
    this.registerTool(
      'web_fetch',
      'Fetch or inspect a simulated web or API endpoint.',
      { url: 'string', method: 'string' },
      async ({ url, method = 'GET' }) => {
        return {
          status: 'success',
          url,
          method,
          statusCode: 200,
          response: {
            success: true,
            message: `Simulated 200 OK response from ${url}`,
            timestamp: new Date().toISOString()
          }
        };
      }
    );
  }

  async executeShell(cmdString) {
    if (!cmdString) return { stdout: '', stderr: 'Empty command', code: 1 };
    const parts = cmdString.trim().split(/\s+/);
    const cmd = parts[0];
    const args = parts.slice(1);

    if (cmd === 'ls') {
      const files = this.fs.listFiles();
      const output = files.map(f => `${f.name.padEnd(20)} ${f.size} bytes (${f.lines} lines)`).join('\n');
      return { stdout: output || '(Workspace is empty)', stderr: '', code: 0 };
    }

    if (cmd === 'cat') {
      if (!args[0]) return { stdout: '', stderr: 'Usage: cat <filename>', code: 1 };
      const res = this.fs.readFile(args[0]);
      if (res.success) return { stdout: res.content, stderr: '', code: 0 };
      return { stdout: '', stderr: res.error, code: 1 };
    }

    if (cmd === 'node' || cmd === 'run' || cmd === 'python' || cmd === 'python3') {
      const target = args[0] || this.fs.currentFile;
      const res = this.fs.readFile(target);
      if (!res.success) return { stdout: '', stderr: `Cannot execute: ${res.error}`, code: 1 };

      const content = res.content;
      // If JS/Node
      if (target.endsWith('.js') || cmd === 'node') {
        const logs = [];
        const virtualConsole = {
          log: (...a) => logs.push(a.map(x => typeof x === 'object' ? JSON.stringify(x) : String(x)).join(' ')),
          error: (...a) => logs.push('[ERROR] ' + a.join(' ')),
          warn: (...a) => logs.push('[WARN] ' + a.join(' '))
        };

        try {
          const fn = new Function('console', 'http', content);
          fn(virtualConsole, {
            get: (u) => logs.push(`[HTTP GET] ${u}`),
            post: (u, d) => logs.push(`[HTTP POST] ${u}`)
          });
          return {
            stdout: logs.join('\n') || `Executed ${target} successfully (no output).`,
            stderr: '',
            code: 0
          };
        } catch (err) {
          return { stdout: logs.join('\n'), stderr: `Runtime Exception: ${err.message}`, code: 1 };
        }
      }

      // If Python simulation
      if (target.endsWith('.py') || cmd.startsWith('python')) {
        // Parse print statements and functions in python
        const lines = content.split('\n');
        const logs = [];
        for (const line of lines) {
          const trimmed = line.trim();
          const matchPrint = trimmed.match(/^print\((.*)\)$/);
          if (matchPrint) {
            let val = matchPrint[1].trim();
            if ((val.startsWith('"') && val.endsWith('"')) || (val.startsWith("'") && val.endsWith("'"))) {
              val = val.slice(1, -1);
            } else if (val.startsWith('f"') || val.startsWith("f'")) {
              val = val.slice(2, -1).replace(/\{.*?\}/g, '[computed]');
            }
            logs.push(val);
          }
        }
        logs.push(`\n[Process completed: exit code 0]`);
        return {
          stdout: logs.join('\n') || `Parsed ${target} (${lines.length} lines). Execution completed.`,
          stderr: '',
          code: 0
        };
      }
    }

    if (cmd === 'diagnose') {
      const diag = await this.tools['diagnostics'].handler({});
      const summary = diag.results.map(r => `[${r.valid ? 'PASS' : 'FAIL'}] ${r.file}: ${r.issues.join(', ')}`).join('\n');
      return { stdout: `=== SAIF SYSTEM DIAGNOSTICS ===\n${summary}`, stderr: '', code: 0 };
    }

    if (cmd === 'clear') {
      return { stdout: '__CLEAR__', stderr: '', code: 0 };
    }

    if (cmd === 'help') {
      const helpText = `SAIF AI Terminal Commands:
- ls                          : List workspace files
- cat <filename>              : View file content
- run / python <file.py>      : Execute Python code
- node <file.js>              : Execute JavaScript
- diagnose                    : Run syntax & structure test
- fetch <url>                 : Test HTTP endpoint
- clear                       : Clear terminal display
- help                        : Display this reference`;
      return { stdout: helpText, stderr: '', code: 0 };
    }

    if (cmd === 'fetch') {
      const url = args[0] || 'https://api.github.com/zen';
      return { stdout: `[FETCH 200 OK] Connected to ${url} (Latency: 28ms)`, stderr: '', code: 0 };
    }

    return {
      stdout: '',
      stderr: `Command not found: ${cmd}. Type 'help' for available commands.`,
      code: 127
    };
  }

  async run(toolName, params) {
    if (!this.tools[toolName]) {
      return { status: 'error', error: `Unknown tool: ${toolName}` };
    }
    try {
      return await this.tools[toolName].handler(params);
    } catch (err) {
      return { status: 'error', error: err.message };
    }
  }
}

window.toolHarness = new ToolHarness(window.workspaceFS);
