package com.gblrod.orbitalnexus.model.planet

import kotlinx.serialization.Serializable

@Serializable
data class PlanetTranslation(
    val locale: String,
    val description: String
)
