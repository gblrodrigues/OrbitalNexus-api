package com.gblrod.orbitalnexus.model

import kotlinx.serialization.Serializable

@Serializable
data class Planet(
    val id: Int,
    val name: String,
    val description: String
)
