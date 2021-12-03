package com.doceazedo.kotlinspigotuwu.utils

import com.doceazedo.kotlinspigotuwu.KotlinSpigotUwU
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import kotlin.random.Random

fun placeNextBlock (player: Player) {
    var playerData = KotlinSpigotUwU.players[player.uniqueId]
    var loc: Location

    if (playerData?.currentBlock != null) {
        player.sendMessage("Colocando próximo bloco...")
        player.playSound(player.location, Sound)

        playerData.lastBlock?.type = Material.AIR

        var negativeOrPositive = if (Random.nextBoolean()) 1 else -1
        loc = playerData.currentBlock!!.location
        loc.x += Random.nextInt(2, 4) * negativeOrPositive
        loc.y += Random.nextInt(0, 1)
        loc.z += Random.nextInt(2, 4) * negativeOrPositive

        KotlinSpigotUwU.players[player.uniqueId] = KotlinSpigotUwU.PlayerData(playerData?.currentBlock, loc.block)
    } else {
        player.sendMessage("Colocando primeiro bloco...")

        loc = player.location
        loc.x += 2
        loc.y += 2

        KotlinSpigotUwU.players[player.uniqueId] = KotlinSpigotUwU.PlayerData(null, loc.block)
    }

    loc.block.type = Material.MELON
}