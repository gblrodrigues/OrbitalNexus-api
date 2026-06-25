package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.model.mission.MissionTranslation
import kotlinx.serialization.Serializable

@Serializable
data class MissionSeed(
    val id: Int,
    val name: String,
    val planetId: Int,
    val launchYear: Int,
    val translations: List<MissionTranslation>
)