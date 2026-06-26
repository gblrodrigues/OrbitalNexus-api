package com.gblrod.orbitalnexus.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.swagger.*

fun Application.configureSwagger() {
    routing {
        swaggerUI(
            path = "swagger",
            swaggerFile = "api/openapi.yaml"
        )
    }
}