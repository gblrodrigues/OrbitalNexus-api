package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.database.table.AstronautsTable
import com.gblrod.orbitalnexus.database.table.MissionTranslationsTable
import com.gblrod.orbitalnexus.database.table.MissionsTable
import com.gblrod.orbitalnexus.database.table.PlanetTranslationsTable
import com.gblrod.orbitalnexus.database.table.PlanetsTable
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

object SeedData {
    val planets = SeedLoader.loadPlanets()
    val missions = SeedLoader.loadMissions()
    val astronauts = SeedLoader.loadAstronauts()

    fun populate() {
        transaction {
            planets.forEach { planet ->
                PlanetsTable.insert {
                    it[id] = planet.id
                    it[name] = planet.name
                }

                planet.descriptions.forEach { translation ->
                    PlanetTranslationsTable.insert {
                        it[planetId] = planet.id
                        it[locale] = translation.locale
                        it[description] = translation.description
                    }
                }
            }

            missions.forEach { mission ->
                MissionsTable.insert {
                    it[id] = mission.id
                    it[name] = mission.name
                    it[planetId] = mission.planetId
                    it[launchYear] = mission.launchYear
                }

                mission.translations.forEach { translation ->
                    MissionTranslationsTable.insert {
                        it[missionId] = mission.id
                        it[locale] = translation.locale
                        it[missionObjective] = translation.missionObjective
                        it[description] = translation.description
                    }
                }
            }

            astronauts.forEach { astronaut ->
                AstronautsTable.insert {
                    it[id] = astronaut.id
                    it[name] = astronaut.name
                    it[nationality] = astronaut.nationality
                    it[image] = astronaut.image
                    it[missionId] = astronaut.missionId
                }
            }
        }
    }
}