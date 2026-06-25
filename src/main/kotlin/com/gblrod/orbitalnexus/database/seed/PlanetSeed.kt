package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.model.planet.PlanetTranslation
import kotlinx.serialization.Serializable

@Serializable
data class PlanetSeed(
    val id: Int,
    val name: String,
    val descriptions: List<PlanetTranslation>
)