package com.doceazedo.autoparkour

import com.doceazedo.autoparkour.commands.ParkourCmd
import com.doceazedo.autoparkour.events.DoParkour
import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.bukkit.plugin.java.JavaPlugin
import java.util.*


class Main : JavaPlugin() {
    companion object {
        var playerBlocks: HashMap<UUID, MutableList<Block>> = HashMap<UUID, MutableList<Block>>()
    }

    override fun onEnable() {
        getCommand("parkour")?.setExecutor(ParkourCmd)
        Bukkit.getPluginManager().registerEvents(DoParkour, this)
    }
}