package com.doceazedo.kotlinspigotuwu.commands

import com.doceazedo.kotlinspigotuwu.utils.placeNextBlock
import com.doceazedo.kotlinspigotuwu.utils.resetBlocks
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object ParkourCmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) return false

        resetBlocks(sender)
        placeNextBlock(sender)
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eBoa sorte!"))
        return true
    }
}