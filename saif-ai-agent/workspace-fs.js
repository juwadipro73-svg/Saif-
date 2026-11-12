/**
 * SAIF AI - Virtual Workspace Filesystem
 * High-performance browser-backed sandbox filesystem with persistent localStorage caching.
 */
class WorkspaceFS {
  constructor() {
    this.storageKey = 'saif_ai_workspace_files_v1';
    this.files = {};
    this.currentFile = 'main.py';
    this.listeners = [];
    this.init();
  }

  init() {
    try {
      const saved = localStorage.getItem(this.storageKey);
      if (saved) {
        this.files = JSON.parse(saved);
      } else {
        this.loadStarterFiles();
      }
    } catch (e) {
      console.warn('Could not read localStorage, using in-memory fs:', e);
      this.loadStarterFiles();
    }
  }

  loadStarterFiles() {
    this.files = {
      'main.py': `"""
SAIF AI - Python Automation & Analytics Engine
Run this script to verify virtual execution environment.
"""

import sys

def calculate_analytics():
    metrics = {
        "engine": "SAIF AI Core",
        "status": "Operational",
        "agent_level": "Autonomous L3",
        "memory_quota": "Unlimited Local",
        "active_tools": ["FileFS", "ShellRunner", "Diagnostics", "McpClient"]
    }
    
    print("=== SAIF AI SYSTEM DIAGNOSTIC ===")
    for key, value in metrics.items():
        if isinstance(value, list):
            print(f"{key.upper()}: {', '.join(value)}")
        else:
            print(f"{key.upper()}: {value}")
    
    print("\n[OK] Virtual Python Sandbox is operational.")

if __name__ == "__main__":
    calculate_analytics()
`,
      'server.js': `/**
 * SAIF AI - Fast Node.js Microservice Architecture
 */
const http = {
  get: (url) => console.log(\`[HTTP GET] Fetching \${url}...\`),
  post: (url, data) => console.log(\`[HTTP POST] Sent payload to \${url}\`)
};

function startServer(port = 8080) {
  console.log(\`🚀 SAIF AI microservice listening on port \${port}\`);
  http.get("https://api.saifai.internal/v1/health");
}

startServer();
`,
      'README.md': `# SAIF AI Project Workspace

This is your autonomous agent workspace. SAIF AI can read, edit, refactor, and create files directly here.

### Available Actions:
1. **Agent Chat:** Ask SAIF AI to build new features, fix bugs, or audit code.
2. **Editor:** Write or edit code with real-time syntax checking.
3. **Terminal:** Execute scripts and run diagnostics.
4. **Skills & MCP:** Switch personas or attach custom tool protocols.
`
    };
    this.save();
  }

  save() {
    try {
      localStorage.setItem(this.storageKey, JSON.stringify(this.files));
      this.notify();
    } catch (e) {
      console.error('Failed to save workspace files:', e);
    }
  }

  onChange(callback) {
    this.listeners.push(callback);
  }

  notify() {
    for (const cb of this.listeners) {
      try { cb(this.files); } catch (e) { console.error(e); }
    }
  }

  readFile(filename) {
    if (filename in this.files) {
      return { success: true, content: this.files[filename] };
    }
    return { success: false, error: `File not found: ${filename}` };
  }

  writeFile(filename, content) {
    if (!filename || typeof filename !== 'string') {
      return { success: false, error: 'Invalid filename' };
    }
    // Clean leading slashes
    const cleanName = filename.replace(/^(\.\/|\/)/, '');
    this.files[cleanName] = content;
    this.save();
    return { success: true, filename: cleanName, bytes: content.length };
  }

  patchFile(filename, target, replacement) {
    const cleanName = filename.replace(/^(\.\/|\/)/, '');
    if (!(cleanName in this.files)) {
      return { success: false, error: `File not found: ${cleanName}` };
    }
    const content = this.files[cleanName];
    if (!content.includes(target)) {
      return { success: false, error: `Target snippet not found in ${cleanName}` };
    }
    const newContent = content.replaceAll(target, replacement);
    this.files[cleanName] = newContent;
    this.save();
    return { success: true, filename: cleanName, length: newContent.length };
  }

  deleteFile(filename) {
    const cleanName = filename.replace(/^(\.\/|\/)/, '');
    if (cleanName in this.files) {
      delete this.files[cleanName];
      if (this.currentFile === cleanName) {
        const remaining = Object.keys(this.files);
        this.currentFile = remaining.length > 0 ? remaining[0] : '';
      }
      this.save();
      return { success: true };
    }
    return { success: false, error: `File ${cleanName} does not exist.` };
  }

  listFiles() {
    return Object.keys(this.files).map(name => ({
      name,
      size: this.files[name].length,
      lines: this.files[name].split('\n').length
    }));
  }

  exportData() {
    return JSON.stringify({
      version: '1.0',
      timestamp: new Date().toISOString(),
      files: this.files
    }, null, 2);
  }

  importData(jsonString) {
    try {
      const parsed = JSON.parse(jsonString);
      if (parsed && typeof parsed.files === 'object') {
        this.files = parsed.files;
        this.save();
        return { success: true, count: Object.keys(this.files).length };
      }
      return { success: false, error: 'Invalid file format' };
    } catch (e) {
      return { success: false, error: e.message };
    }
  }

  reset() {
    this.loadStarterFiles();
    this.currentFile = 'main.py';
    return { success: true };
  }
}

// Global instance
window.workspaceFS = new WorkspaceFS();
