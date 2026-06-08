package com.gblrod.orbitalnexus.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String
)