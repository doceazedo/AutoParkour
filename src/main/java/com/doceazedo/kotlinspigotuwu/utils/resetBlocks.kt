package com.doceazedo.kotlinspigotuwu.utils

import com.doceazedo.kotlinspigotuwu.KotlinSpigotUwU
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player

fun resetBlocks (player: Player) {
    var blocks = KotlinSpigotUwU.playerBlocks[player.uniqueId] ?: return
    for (block in blocks) block.type = Material.AIR
    KotlinSpigotUwU.playerBlocks[player.uniqueId]?.clear()

    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aAll parkour blocks were removed."))
}