package com.gblrod.orbitalnexus.model.planet

import kotlinx.serialization.Serializable

@Serializable
data class Planet(
    val id: Int,
    val name: String,
    val description: String
)
