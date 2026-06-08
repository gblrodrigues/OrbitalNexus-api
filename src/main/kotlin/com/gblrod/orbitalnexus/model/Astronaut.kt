package com.gblrod.orbitalnexus.model

import kotlinx.serialization.Serializable

@Serializable
data class Astronaut(
    val id: Int,
    val name: String,
    val nationality: String,
    val missionId: Int,
    val image: String? = null
)
