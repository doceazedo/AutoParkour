package com.doceazedo.kotlinspigotuwu.utils

import com.doceazedo.kotlinspigotuwu.KotlinSpigotUwU
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import kotlin.random.Random

fun placeNextBlock (player: Player) {
    var playerData = KotlinSpigotUwU.players[player.uniqueId]
    var loc: Location

    if (playerData?.currentBlock != null) {
        playerData.lastBlock?.type = Material.AIR

        loc = player.location.add(player.location.direction.multiply(Random.nextInt(3, 5)))
        loc.y = playerData.currentBlock!!.location.y + Random.nextInt(0, 2)
        // TODO: multiply direction until 4, tweak x and z between -1 and 1

        KotlinSpigotUwU.players[player.uniqueId] = KotlinSpigotUwU.PlayerData(playerData?.currentBlock, loc.block)
    } else {
        loc = player.location
        loc.y -= 2

        KotlinSpigotUwU.players[player.uniqueId] = KotlinSpigotUwU.PlayerData(null, loc.block)
    }

    loc.block.type = Material.MELON
    player.world.playSound(player.location, Sound.ENTITY_CHICKEN_EGG, 1f, 1f)
}