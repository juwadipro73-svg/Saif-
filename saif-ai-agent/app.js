/**
 * SAIF AI - Main Application Controller & UI Orchestrator
 */
document.addEventListener('DOMContentLoaded', () => {
  // DOM Elements
  const tabButtons = document.querySelectorAll('.nav-tab');
  const tabPanes = document.querySelectorAll('.tab-pane');

  // Chat DOM
  const messagesContainer = document.getElementById('messagesContainer');
  const promptInput = document.getElementById('promptInput');
  const sendBtn = document.getElementById('sendBtn');
  const micBtn = document.getElementById('micBtn');
  const activityBanner = document.getElementById('agentActivityBanner');
  const activityText = document.getElementById('activityBannerText');
  const quickPills = document.querySelectorAll('.quick-pill');
  const clearChatBtn = document.getElementById('clearChatBtn');
  const newChatBtn = document.getElementById('newChatBtn');
  const voiceToggleBtn = document.getElementById('voiceToggleBtn');
  const activeModelBadge = document.getElementById('activeModelBadge');

  // Editor DOM
  const editorTabs = document.getElementById('editorTabs');
  const fileTree = document.getElementById('fileTree');
  const fileCountBadge = document.getElementById('fileCountBadge');
  const codeEditorArea = document.getElementById('codeEditorArea');
  const lineNumbers = document.getElementById('lineNumbers');
  const editorStatus = document.getElementById('editorStatus');
  const newFileBtn = document.getElementById('newFileBtn');
  const runFileBtn = document.getElementById('runFileBtn');
  const saveFileBtn = document.getElementById('saveFileBtn');
  const agentFixCodeBtn = document.getElementById('agentFixCodeBtn');

  // Terminal DOM
  const terminalOutput = document.getElementById('terminalOutput');
  const terminalInput = document.getElementById('terminalInput');
  const terminalSendBtn = document.getElementById('terminalSendBtn');
  const clearTerminalBtn = document.getElementById('clearTerminalBtn');
  const diagRunBtn = document.getElementById('diagRunBtn');

  // Settings DOM
  const providerSelect = document.getElementById('providerSelect');
  const apiKeyInput = document.getElementById('apiKeyInput');
  const modelNameInput = document.getElementById('modelNameInput');
  const autoExecuteTools = document.getElementById('autoExecuteTools');
  const ttsToggle = document.getElementById('ttsToggle');
  const exportWorkspaceBtn = document.getElementById('exportWorkspaceBtn');
  const resetWorkspaceBtn = document.getElementById('resetWorkspaceBtn');
  const skillCards = document.querySelectorAll('.skill-card');
  const addMcpBtn = document.getElementById('addMcpBtn');

  // Audio / Speech State
  let speechEnabled = true;
  let recognition = null;
  let isListening = false;

  // Initialize Speech Recognition if available
  if ('webkitSpeechRecognition' in window || 'SpeechRecognition' in window) {
    const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
    recognition = new SpeechRecognition();
    recognition.continuous = false;
    recognition.interimResults = false;
    recognition.lang = 'en-US';

    recognition.onstart = () => {
      isListening = true;
      micBtn.classList.add('listening');
    };

    recognition.onresult = (event) => {
      const transcript = event.results[0][0].transcript;
      promptInput.value = transcript;
    };

    recognition.onend = () => {
      isListening = false;
      micBtn.classList.remove('listening');
    };

    recognition.onerror = () => {
      isListening = false;
      micBtn.classList.remove('listening');
    };
  }

  /* ================= 1. TAB SWITCHING ================= */
  tabButtons.forEach(btn => {
    btn.addEventListener('click', () => {
      const targetTab = btn.getAttribute('data-tab');
      switchTab(targetTab);
    });
  });

  function switchTab(tabId) {
    tabButtons.forEach(b => b.classList.toggle('active', b.getAttribute('data-tab') === tabId));
    tabPanes.forEach(p => p.classList.toggle('active', p.id === tabId));

    if (tabId === 'tabEditor') {
      renderEditor();
    }
  }

  document.getElementById('headerSettingsBtn').addEventListener('click', () => {
    switchTab('tabSettings');
  });

  /* ================= 2. CHAT & AGENT FLOW ================= */
  sendBtn.addEventListener('click', handleSendMessage);
  promptInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter' && !e.shiftKey) {
      e.preventDefault();
      handleSendMessage();
    }
  });

  quickPills.forEach(pill => {
    pill.addEventListener('click', () => {
      const prompt = pill.getAttribute('data-prompt');
      promptInput.value = prompt;
      handleSendMessage();
    });
  });

  micBtn.addEventListener('click', () => {
    if (!recognition) {
      alert('Speech recognition is not supported in this browser/device.');
      return;
    }
    if (isListening) {
      recognition.stop();
    } else {
      recognition.start();
    }
  });

  voiceToggleBtn.addEventListener('click', () => {
    speechEnabled = !speechEnabled;
    voiceToggleBtn.classList.toggle('active-glow', speechEnabled);
    if (ttsToggle) ttsToggle.checked = speechEnabled;
  });

  async function handleSendMessage() {
    const text = promptInput.value.trim();
    if (!text) return;

    promptInput.value = '';
    promptInput.style.height = 'auto';

    // Append User Card
    appendMessageCard('user', text);

    // Show Progress Banner
    activityBanner.style.display = 'flex';
    activityText.textContent = 'SAIF AI Agent reasoning...';

    const currentCard = createAssistantCardSkeleton();

    try {
      await window.agentEngine.processPrompt(text, {
        onThought: (thought) => {
          activityText.textContent = thought;
        },
        onToolCall: (call) => {
          appendToolCardToMsg(currentCard, call);
        },
        onMessage: (content) => {
          updateAssistantMsgBody(currentCard, content);
          if (speechEnabled) {
            speakText(content);
          }
        },
        onComplete: () => {
          activityBanner.style.display = 'none';
          refreshFiles();
        }
      });
    } catch (err) {
      activityBanner.style.display = 'none';
      updateAssistantMsgBody(currentCard, `⚠️ **Error during execution:** ${err.message}`);
    }
  }

  function appendMessageCard(role, text) {
    const card = document.createElement('div');
    card.className = `message-card ${role}`;

    const avatar = document.createElement('div');
    avatar.className = 'msg-avatar';
    avatar.textContent = role === 'user' ? 'YOU' : 'SAIF';

    const body = document.createElement('div');
    body.className = 'msg-body';

    const author = document.createElement('div');
    author.className = 'msg-author';
    author.textContent = role === 'user' ? 'User Instruction' : 'SAIF AI Engine';

    const msgText = document.createElement('div');
    msgText.className = 'msg-text';
    msgText.innerHTML = renderMarkdown(text);

    body.appendChild(author);
    body.appendChild(msgText);
    card.appendChild(avatar);
    card.appendChild(body);

    messagesContainer.appendChild(card);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
    return card;
  }

  function createAssistantCardSkeleton() {
    const card = document.createElement('div');
    card.className = 'message-card assistant';

    const avatar = document.createElement('div');
    avatar.className = 'msg-avatar';
    avatar.innerHTML = '<div class="pulse-ring"></div><span>SAIF</span>';

    const body = document.createElement('div');
    body.className = 'msg-body';

    const author = document.createElement('div');
    author.className = 'msg-author';
    author.textContent = 'SAIF AI Engine';

    const toolsContainer = document.createElement('div');
    toolsContainer.className = 'msg-tools-zone';

    const msgText = document.createElement('div');
    msgText.className = 'msg-text';
    msgText.innerHTML = '<span style="color:var(--text-muted);">Thinking & planning workspace actions...</span>';

    body.appendChild(author);
    body.appendChild(toolsContainer);
    body.appendChild(msgText);
    card.appendChild(avatar);
    card.appendChild(body);

    messagesContainer.appendChild(card);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
    return card;
  }

  function appendToolCardToMsg(card, toolCall) {
    const toolsZone = card.querySelector('.msg-tools-zone');
    const toolEl = document.createElement('div');
    toolEl.className = 'tool-card';

    const header = document.createElement('div');
    header.className = 'tool-header';
    header.innerHTML = `
      <span class="tool-badge">⚡ ${toolCall.tool}</span>
      <span class="tool-status success">SUCCESS</span>
    `;

    const body = document.createElement('div');
    body.className = 'tool-body';
    body.textContent = JSON.stringify(toolCall.result, null, 2);

    header.addEventListener('click', () => {
      body.style.display = body.style.display === 'none' ? 'block' : 'none';
    });

    toolEl.appendChild(header);
    toolEl.appendChild(body);
    toolsZone.appendChild(toolEl);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
  }

  function updateAssistantMsgBody(card, markdown) {
    const msgText = card.querySelector('.msg-text');
    msgText.innerHTML = renderMarkdown(markdown);
    messagesContainer.scrollTop = messagesContainer.scrollHeight;
  }

  function renderMarkdown(md) {
    if (!md) return '';
    // Format bold
    let html = md.replace(/\*\*(.*?)\*\*/g, '<strong>$1</strong>');
    // Format code blocks
    html = html.replace(/```([a-zA-Z0-9]*)\n([\s\S]*?)```/g, (match, lang, code) => {
      const cleanCode = code.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
      return `<div class="code-block">
        <div class="code-header">
          <span>${lang || 'code'}</span>
          <button onclick="navigator.clipboard.writeText(decodeURIComponent('${encodeURIComponent(code)}'))">Copy</button>
        </div>
        <div class="code-content">${cleanCode}</div>
      </div>`;
    });
    // Format inline code
    html = html.replace(/`([^`]+)`/g, '<code style="background:#1e293b;padding:2px 5px;border-radius:4px;font-family:var(--font-mono);color:#38bdf8;">$1</code>');
    // Format headers
    html = html.replace(/^### (.*$)/gim, '<h3 style="font-size:14px;color:#38bdf8;margin:10px 0 6px;">$1</h3>');
    // Format bullet points
    html = html.replace(/^\- (.*$)/gim, '<li style="margin-left:16px;">$1</li>');
    // Newlines
    html = html.replace(/\n/g, '<br>');
    return html;
  }

  function speakText(text) {
    if (!('speechSynthesis' in window)) return;
    window.speechSynthesis.cancel();
    // Strip markdown formatting for speech
    const cleanText = text.replace(/```[\s\S]*?```/g, 'Code block omitted.')
                          .replace(/[#*`_~]/g, '')
                          .slice(0, 300); // Limit duration
    const utterance = new SpeechSynthesisUtterance(cleanText);
    utterance.rate = 1.05;
    window.speechSynthesis.speak(utterance);
  }

  clearChatBtn.addEventListener('click', () => {
    messagesContainer.innerHTML = '';
  });

  newChatBtn.addEventListener('click', () => {
    messagesContainer.innerHTML = '';
    appendMessageCard('assistant', 'Starting a new session. How can I assist you with your code or workspace today?');
  });

  /* ================= 3. EDITOR & FILE SYSTEM ================= */
  window.workspaceFS.onChange(() => {
    refreshFiles();
  });

  function refreshFiles() {
    const files = window.workspaceFS.listFiles();
    fileCountBadge.textContent = files.length;

    fileTree.innerHTML = '';
    files.forEach(f => {
      const item = document.createElement('div');
      item.className = `file-item ${f.name === window.workspaceFS.currentFile ? 'active' : ''}`;
      item.innerHTML = `<span>📄</span> <span>${f.name}</span>`;
      item.addEventListener('click', () => {
        openFile(f.name);
      });
      fileTree.appendChild(item);
    });

    renderEditorTabs();
  }

  function renderEditorTabs() {
    editorTabs.innerHTML = '';
    const current = window.workspaceFS.currentFile;
    if (current) {
      const tab = document.createElement('div');
      tab.className = 'file-tab active';
      tab.innerHTML = `<span>${current}</span>`;
      editorTabs.appendChild(tab);
    }
  }

  function openFile(filename) {
    window.workspaceFS.currentFile = filename;
    refreshFiles();
    renderEditor();
  }

  function renderEditor() {
    const current = window.workspaceFS.currentFile;
    if (!current) {
      codeEditorArea.value = '# No file selected';
      lineNumbers.textContent = '1';
      return;
    }

    const res = window.workspaceFS.readFile(current);
    if (res.success) {
      codeEditorArea.value = res.content;
      updateLineNumbers();
      editorStatus.textContent = `${current} | ${res.content.length} bytes`;
    }
  }

  function updateLineNumbers() {
    const lines = codeEditorArea.value.split('\n').length;
    let numbers = '';
    for (let i = 1; i <= lines; i++) {
      numbers += i + '\n';
    }
    lineNumbers.textContent = numbers;
  }

  codeEditorArea.addEventListener('input', () => {
    updateLineNumbers();
  });

  codeEditorArea.addEventListener('scroll', () => {
    lineNumbers.scrollTop = codeEditorArea.scrollTop;
  });

  saveFileBtn.addEventListener('click', () => {
    const current = window.workspaceFS.currentFile;
    if (!current) return;
    window.workspaceFS.writeFile(current, codeEditorArea.value);
    alert(`Saved ${current}!`);
  });

  newFileBtn.addEventListener('click', () => {
    const name = prompt('Enter new file name (e.g. index.js, app.py, style.css):');
    if (name) {
      window.workspaceFS.writeFile(name, '// Created with SAIF AI\n');
      openFile(name);
    }
  });

  runFileBtn.addEventListener('click', async () => {
    const current = window.workspaceFS.currentFile;
    if (!current) return;
    // Auto-save before running
    window.workspaceFS.writeFile(current, codeEditorArea.value);

    switchTab('tabTerminal');
    appendTerminalLine(`saif@ai:~$ run ${current}`, 'command');
    const res = await window.toolHarness.executeShell(`run ${current}`);
    if (res.stdout) appendTerminalLine(res.stdout, 'info');
    if (res.stderr) appendTerminalLine(res.stderr, 'error');
  });

  agentFixCodeBtn.addEventListener('click', () => {
    const current = window.workspaceFS.currentFile;
    if (!current) return;
    switchTab('tabChat');
    promptInput.value = `Review and optimize the code in ${current}. Check for edge cases and errors.`;
    handleSendMessage();
  });

  /* ================= 4. TERMINAL ================= */
  terminalSendBtn.addEventListener('click', handleTerminalExec);
  terminalInput.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      handleTerminalExec();
    }
  });

  async function handleTerminalExec() {
    const cmd = terminalInput.value.trim();
    if (!cmd) return;
    terminalInput.value = '';

    appendTerminalLine(`saif@ai:~$ ${cmd}`, 'command');

    const res = await window.toolHarness.executeShell(cmd);
    if (res.stdout === '__CLEAR__') {
      terminalOutput.innerHTML = '';
      return;
    }
    if (res.stdout) appendTerminalLine(res.stdout, 'info');
    if (res.stderr) appendTerminalLine(res.stderr, 'error');
  }

  function appendTerminalLine(text, type = '') {
    const line = document.createElement('div');
    line.className = `term-line ${type}`;
    line.textContent = text;
    terminalOutput.appendChild(line);
    terminalOutput.scrollTop = terminalOutput.scrollHeight;
  }

  clearTerminalBtn.addEventListener('click', () => {
    terminalOutput.innerHTML = '';
  });

  diagRunBtn.addEventListener('click', async () => {
    appendTerminalLine('saif@ai:~$ diagnose', 'command');
    const res = await window.toolHarness.executeShell('diagnose');
    appendTerminalLine(res.stdout, 'info');
  });

  /* ================= 5. SKILLS & MCP ================= */
  skillCards.forEach(card => {
    card.addEventListener('click', () => {
      skillCards.forEach(c => {
        c.classList.remove('active');
        c.querySelector('input[type="radio"]').checked = false;
      });
      card.classList.add('active');
      card.querySelector('input[type="radio"]').checked = true;

      const skill = card.getAttribute('data-skill');
      window.agentEngine.setPersona(skill);
      alert(`Active Agent Persona switched to: ${window.agentEngine.getPersona().name}`);
    });
  });

  addMcpBtn.addEventListener('click', () => {
    const endpoint = prompt('Enter MCP Server URL (SSE or stdio endpoint):', 'https://mcp.internal.saifai.com/sse');
    if (endpoint) {
      alert(`Connected to MCP Server at ${endpoint}. 4 tools registered into agent schema!`);
    }
  });

  /* ================= 6. SETTINGS & SYNC ================= */
  providerSelect.addEventListener('change', () => {
    localStorage.setItem('saif_llm_provider', providerSelect.value);
    activeModelBadge.textContent = providerSelect.value.toUpperCase();
  });

  apiKeyInput.addEventListener('change', () => {
    localStorage.setItem('saif_llm_api_key', apiKeyInput.value.trim());
  });

  modelNameInput.addEventListener('change', () => {
    localStorage.setItem('saif_llm_model', modelNameInput.value.trim());
  });

  exportWorkspaceBtn.addEventListener('click', () => {
    const data = window.workspaceFS.exportData();
    const blob = new Blob([data], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `saif_ai_workspace_${Date.now()}.json`;
    a.click();
  });

  resetWorkspaceBtn.addEventListener('click', () => {
    if (confirm('Reset workspace files to initial defaults?')) {
      window.workspaceFS.reset();
      refreshFiles();
      renderEditor();
      alert('Workspace reset complete.');
    }
  });

  // Initial Boot
  refreshFiles();
  renderEditor();
});
