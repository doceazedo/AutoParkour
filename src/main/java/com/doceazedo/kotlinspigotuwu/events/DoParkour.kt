package com.doceazedo.kotlinspigotuwu.events

import com.doceazedo.kotlinspigotuwu.KotlinSpigotUwU
import com.doceazedo.kotlinspigotuwu.utils.placeNextBlock
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import kotlin.random.Random

object DoParkour : Listener {
    @EventHandler
    public fun onPlayerMove(e: PlayerMoveEvent) {
        var lastBlock = KotlinSpigotUwU.players[e.player.uniqueId]?.lastBlock
        var currentBlock = KotlinSpigotUwU.players[e.player.uniqueId]?.currentBlock

        if (e.to?.block?.getRelative(BlockFace.DOWN) != currentBlock) return
        if (lastBlock == currentBlock) return

        placeNextBlock(e.player)
        e.player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aIsso aí!"))
    }
}