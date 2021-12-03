package com.doceazedo.kotlinspigotuwu

import com.doceazedo.kotlinspigotuwu.commands.ParkourCmd
import com.doceazedo.kotlinspigotuwu.events.DoParkour
import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.bukkit.plugin.java.JavaPlugin
import java.util.*


class KotlinSpigotUwU : JavaPlugin() {
    companion object {
        var playerBlocks: HashMap<UUID, MutableList<Block>> = HashMap<UUID, MutableList<Block>>()
    }

    override fun onEnable() {
        getCommand("parkour")?.setExecutor(ParkourCmd)
        Bukkit.getPluginManager().registerEvents(DoParkour, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}