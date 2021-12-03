package com.doceazedo.kotlinspigotuwu.utils

import com.doceazedo.kotlinspigotuwu.KotlinSpigotUwU
import org.bukkit.Material
import org.bukkit.entity.Player

fun resetBlocks (player: Player) {
    var playerData = KotlinSpigotUwU.players[player.uniqueId]

    playerData?.lastBlock?.type = Material.AIR
    playerData?.currentBlock?.type = Material.AIR

    KotlinSpigotUwU.players[player.uniqueId] = KotlinSpigotUwU.PlayerData(null, null)
}