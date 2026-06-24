package com.gblrod.orbitalnexus.routes

import com.gblrod.orbitalnexus.model.ErrorResponse
import com.gblrod.orbitalnexus.service.MissionService
import com.gblrod.orbitalnexus.util.locale
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.missionRoutes(
    missionService: MissionService
) {
    route("v1/missions") {
        get {
            val missions = missionService.getAll()
            call.respond(missions)
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = ErrorResponse(message = "Invalid mission id")
                )
                return@get
            }

            val mission = missionService.getById(id)

            if (mission != null) {
                call.respond(mission)
            } else {
                call.respond(
                    status = HttpStatusCode.NotFound,
                    message = ErrorResponse(message = "Mission not found")
                )
            }
        }

        get("/{id}/astronauts") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = ErrorResponse(message = "Invalid mission id")
                )
                return@get
            }

            val mission = missionService.getById(id)

            if (mission == null) {
                call.respond(
                    status = HttpStatusCode.NotFound,
                    message = ErrorResponse(message = "Mission not found")
                )
                return@get
            }

            val astronaut = missionService.getAstronautsByMissionId(id)

            call.respond(astronaut)
        }

        get("/{id}/planet") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = ErrorResponse(message = "Invalid mission id")
                )
                return@get
            }

            val locale = call.locale()
            val planet = missionService.getPlanetByMissionId(id, locale)

            if (planet == null) {
                call.respond(
                    status = HttpStatusCode.NotFound,
                    message = ErrorResponse(message = "Mission or planet not found")
                )
                return@get
            }

            call.respond(planet)
        }
    }
}