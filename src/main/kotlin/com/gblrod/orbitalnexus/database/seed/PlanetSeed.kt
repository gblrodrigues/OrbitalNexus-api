package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.model.planet.PlanetTranslation

data class PlanetSeed(
    val id: Int,
    val name: String,
    val descriptions: List<PlanetTranslation>
)