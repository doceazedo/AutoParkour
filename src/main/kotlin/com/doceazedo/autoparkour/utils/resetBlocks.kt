package com.doceazedo.autoparkour.utils

import com.doceazedo.autoparkour.Main
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

fun resetBlocks (player: Player) {
    var blocks = Main.playerBlocks[player.uniqueId] ?: return
    for (block in blocks) block.type = Material.AIR
    Main.playerBlocks[player.uniqueId]?.clear()

    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aAll parkour blocks were removed."))
}