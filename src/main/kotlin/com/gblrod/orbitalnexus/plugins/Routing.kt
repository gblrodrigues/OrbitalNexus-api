package com.gblrod.orbitalnexus.plugins

import com.gblrod.orbitalnexus.routes.astronautRoutes
import com.gblrod.orbitalnexus.routes.missionRoutes
import com.gblrod.orbitalnexus.routes.planetRoutes
import com.gblrod.orbitalnexus.service.AstronautService
import com.gblrod.orbitalnexus.service.MissionService
import com.gblrod.orbitalnexus.service.PlanetService
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val planetService by inject <PlanetService>()
    val astronautService by inject<AstronautService>()
    val missionService by inject<MissionService>()

    routing {
        planetRoutes(
            planetService = planetService,
            missionService = missionService
        )
        missionRoutes(
            missionService = missionService
        )
        astronautRoutes(
            astronautService = astronautService
        )
    }
}