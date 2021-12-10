package com.doceazedo.autoparkour.events

import com.doceazedo.autoparkour.Main
import com.doceazedo.autoparkour.utils.placeNextBlock
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

object DoParkour : Listener {
    @EventHandler
    public fun onPlayerMove(e: PlayerMoveEvent) {
        val blocks = Main.playerBlocks[e.player.uniqueId] ?: return
        if (blocks.isEmpty() || e.to!!.block.getRelative(BlockFace.DOWN) != blocks.last()) return
        placeNextBlock(e.player)
    }
}