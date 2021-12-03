package com.doceazedo.autoparkour.utils

import com.doceazedo.autoparkour.Main
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import kotlin.random.Random

fun placeNextBlock (player: Player) {
    var blocks = Main.playerBlocks[player.uniqueId]
    if (blocks == null) blocks = ArrayList()

    if (blocks.isEmpty()) {
        // Starting, placing first block
        var loc = player.location
        loc.y = player.location.y - 1

        if (loc.block.type != Material.AIR) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThe block below you must be air!"))
            return
        }

        loc.block.type = Material.MELON
        blocks.add(loc.block)

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aGood luck and have fun, &e" + player.displayName + "&a!"))
    } else {
        // Just step on last block, deleting old blocks
        val lastBlock = blocks.last()
        for (block in blocks) {
            if (block == lastBlock) continue
            block.type = Material.AIR
        }
        blocks.clear()
        blocks.add(lastBlock)
    }

    for (i in 1..5) {
        var loc = blocks.last().location.add(player.location.direction.multiply(3))
        loc.x = loc.x + Random.nextInt(-1, 1)
        loc.z = loc.z + Random.nextInt(-1, 1)
        loc.y = blocks.last().location.y + Random.nextInt(0, 2)
        loc.block.type = Material.MELON
        blocks.add(loc.block)
    }

    Main.playerBlocks[player.uniqueId] = blocks
    player.world.playSound(player.location, Sound.ENTITY_CHICKEN_EGG, 1f, 1f)
}