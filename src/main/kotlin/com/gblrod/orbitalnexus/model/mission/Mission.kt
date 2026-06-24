package com.gblrod.orbitalnexus.model.mission

import kotlinx.serialization.Serializable

@Serializable
data class Mission(
    val id: Int,
    val name: String,
    val missionObjective: String,
    val description: String,
    val planetId: Int,
    val launchYear: Int
)