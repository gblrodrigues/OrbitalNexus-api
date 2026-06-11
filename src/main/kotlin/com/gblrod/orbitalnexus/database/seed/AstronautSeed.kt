package com.gblrod.orbitalnexus.database.seed

data class AstronautSeed(
    val id: Int,
    val name: String,
    val nationality: String,
    val image: String?,
    val missionId: Int
)