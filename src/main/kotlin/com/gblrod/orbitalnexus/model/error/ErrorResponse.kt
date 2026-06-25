package com.gblrod.orbitalnexus.model.error

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String
)