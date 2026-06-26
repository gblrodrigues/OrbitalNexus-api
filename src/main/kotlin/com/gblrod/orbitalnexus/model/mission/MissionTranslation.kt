package com.gblrod.orbitalnexus.model.mission

import kotlinx.serialization.Serializable

@Serializable
data class MissionTranslation(
    val locale: String,
    val missionObjective: String,
    val description: String
)