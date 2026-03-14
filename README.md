# VanishPlugin

A powerful vanish plugin for Minecraft Spigot servers that allows administrators and players to become invisible and hidden from the server.

## Features

- **Packet Filtering**: Server stops sending other players your location and movement data
- **Fake Quit Message**: System sends all users an automatic "left the server" message
- **Spectator-like Mode**: Players can fly and pass through blocks while remaining in their original gamemode
- **Tab List Hiding**: Player name disappears from the connected players menu
- **No Animations**: Your actions don't create noise or animations for others

## Commands

- `/vanish` - Toggle vanish mode on/off
- `/v` - Alias for `/vanish`

## Permissions

- `vanish.use` - Permission to use the vanish command

## Installation

1. Download the plugin JAR file
2. Place it in your server's `plugins` folder
3. Restart your server
4. Configure permissions for players

## Usage

Simply run `/vanish` to toggle vanish mode. When vanished:
- You become invisible to other players
- Other players see a fake "left the server" message
- You gain the ability to fly
- Your name is removed from the player list
- Your actions (breaking blocks, opening chests) are invisible to others

Run `/vanish` again to become visible.