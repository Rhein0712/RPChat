# RPChat – Immersive Roleplay Chat System for Minecraft 1.20.6

**RPChat** is a lightweight, fully customizable chat plugin designed for immersive Minecraft roleplay servers. It supports local roleplay communication, global out-of-character chat, whispering, yelling, staff channels, and more. Built for **Minecraft 1.20.6** and tested on **PebbleHost** environments.

---

## 📦 Features

- 🗣️ **/rp** – Toggle local roleplay chat (visible to nearby players)
- 💬 **/ooc** – Toggle global out-of-character chat (default if not in RP)
- 🔊 **/yell [message]** – Send a louder RP message to a wider radius
- 🤫 **/whisper [message]** – Send a quiet RP message to nearby players only
- 🧍 **/me [action]** – Emote-style messages (e.g. "*Thomas draws his sword.*")
- 📢 **/looc [message]** – Local out-of-character message (20 block radius)
- 👮 **/staff** – Toggle staff-only chat channel (green `[Staff]` prefix)
- 👥 **/staffadd [player]** / **/staffremove [player]** – Manage staff list (operator only)
- 📋 **/stafflist** – View current staff chat members (operator only)
- 📖 **/rpchathelp** – List all commands with descriptions

---

## 🎮 Chat Modes

Each player can only be in one chat mode at a time:
- **RP Mode**: Normal messages are sent to local RP chat
- **OOC Mode**: Normal messages are sent globally (default)
- **Staff Mode**: Messages sent to private staff channel

Overrides like `/whisper`, `/yell`, `/me`, and `/looc` work in any mode.

---

## 🛠️ Installation

1. Drop the compiled plugin `.jar` into your server’s `plugins/` directory
2. Restart or reload your server
3. Optional: Configure permissions and ranges in a future config

---

## ✅ Requirements

- Minecraft 1.20.6
- Spigot or Paper (tested with PebbleHost)
- Java 17+

---

## 🔐 Permissions (optional, coming soon)

| Node               | Description                 |
|--------------------|-----------------------------|
| `rpchat.staff`     | Access to `/staff` commands |
| `rpchat.use`       | Use RP/OOC chat features    |

---

## 🙏 Credits

Built by Rhein0712 for historical RP communities.