package com.doceazedo.kotlinspigotuwu

import com.doceazedo.kotlinspigotuwu.commands.ParkourCmd
import com.doceazedo.kotlinspigotuwu.events.DoParkour
import org.bukkit.Bukkit
import org.bukkit.block.Block
import org.bukkit.plugin.java.JavaPlugin
import java.util.*


class KotlinSpigotUwU : JavaPlugin() {
    data class PlayerData(
        var lastBlock: Block?,
        var currentBlock: Block?
    )

    companion object {
        var players: HashMap<UUID, PlayerData> = HashMap<UUID, PlayerData>()
    }

    override fun onEnable() {
        getCommand("parkour")?.setExecutor(ParkourCmd)
        Bukkit.getPluginManager().registerEvents(DoParkour, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}