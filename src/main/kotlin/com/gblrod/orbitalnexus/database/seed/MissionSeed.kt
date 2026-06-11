package com.gblrod.orbitalnexus.database.seed

data class MissionSeed(
    val id: Int,
    val name: String,
    val planetId: Int,
    val launchYear: Int
)