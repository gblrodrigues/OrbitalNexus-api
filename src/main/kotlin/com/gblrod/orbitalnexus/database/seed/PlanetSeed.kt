package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.model.Translation

data class PlanetSeed(
    val id: Int,
    val name: String,
    val descriptions: List<Translation>
)