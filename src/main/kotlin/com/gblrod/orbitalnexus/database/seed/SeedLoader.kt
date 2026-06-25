package com.gblrod.orbitalnexus.database.seed

import kotlinx.serialization.json.Json

object SeedLoader {
    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    fun loadPlanets(): List<PlanetSeed> {
        val content = SeedLoader::class.java
            .getResource("/seed/planets.json")
            ?.readText()
            ?: error("planets.json not found")

        return json.decodeFromString(content)
    }

    fun loadMissions(): List<MissionSeed> {
        val content = SeedLoader::class.java
            .getResource("/seed/missions.json")
            ?.readText()
            ?: error("missions.json not found")

        return json.decodeFromString(content)
    }

    fun loadAstronauts(): List<AstronautSeed> {
        val content = SeedLoader::class.java
            .getResource("/seed/astronauts.json")
            ?.readText()
            ?: error("astronauts.json not found")

        return json.decodeFromString(content)
    }
}