package com.doceazedo.autoparkour.commands

import com.doceazedo.autoparkour.Main
import com.doceazedo.autoparkour.utils.placeNextBlock
import com.doceazedo.autoparkour.utils.resetBlocks
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object ParkourCmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) return false

        var blocks = Main.playerBlocks[sender.uniqueId]
        if (blocks == null) blocks = ArrayList()

        if (blocks.isEmpty()) {
            placeNextBlock(sender)
        } else {
            resetBlocks(sender)
        }

        return true
    }
}