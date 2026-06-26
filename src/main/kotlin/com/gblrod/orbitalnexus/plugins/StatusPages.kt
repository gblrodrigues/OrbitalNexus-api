package com.gblrod.orbitalnexus.plugins

import com.gblrod.orbitalnexus.model.error.ErrorResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ErrorResponse(
                    message = cause.message ?: "Internal server error"
                )
            )
        }
    }
}