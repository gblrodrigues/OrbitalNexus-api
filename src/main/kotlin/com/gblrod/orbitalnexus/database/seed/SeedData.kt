package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.database.AstronautsTable
import com.gblrod.orbitalnexus.database.MissionsTable
import com.gblrod.orbitalnexus.database.PlanetTranslationsTable
import com.gblrod.orbitalnexus.database.PlanetsTable
import com.gblrod.orbitalnexus.model.Translation
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

object SeedData {
    private const val BASE_IMAGE_URL = "http://192.168.3.7:8080/assets/astronauts/"

    private val planets = listOf(
        PlanetSeed(
            id = 1,
            name = "Kepler Prime",
            descriptions = listOf(
                Translation(locale = "en-US", description = "Rocky planet located in the Vega sector."),
                Translation(locale = "pt-BR", description = "Planeta rochoso localizado no setor Vega."),
                Translation(locale = "es-ES", description = "Planeta rocoso ubicado en el sector Vega.")
            )
        ),
        PlanetSeed(
            id = 2,
            name = "Nova Terra",
            descriptions = listOf(
                Translation(locale = "en-US", description = "Habitable world with vast oceans."),
                Translation(locale = "pt-BR", description = "Mundo habitável com vastos oceanos."),
                Translation(locale = "es-ES", description = "Un mundo habitable con vastos océanos.")
            )
        ),
        PlanetSeed(
            id = 3,
            name = "Eclipse Haven",
            descriptions = listOf(
                Translation(
                    locale = "en-US",
                    description = "Temperate planet surrounded by massive ring systems and rich mineral deposits."
                ),
                Translation(
                    locale = "pt-BR",
                    description = "Planeta temperado rodeado por enormes sistemas de anéis e ricos depósitos minerais."
                ),
                Translation(
                    locale = "es-ES",
                    description = "Planeta templado rodeado de enormes sistemas de anillos y ricos depósitos minerales."
                )
            )
        ),

        PlanetSeed(
            id = 4,
            name = "Zenith IX",
            descriptions = listOf(
                Translation(
                    locale = "en-US",
                    description = "Remote desert world known for its towering crystal formations and extreme climate."
                ),
                Translation(
                    locale = "pt-BR",
                    description = "Mundo desértico remoto conhecido por suas imponentes formações cristalinas e clima extremo."
                ),
                Translation(
                    locale = "es-ES",
                    description = "Mundo desértico remoto conocido por sus imponentes formaciones cristalinas y su clima extremo."
                )
            )
        )
    )

    private val missions = listOf(
        MissionSeed(
            id = 1,
            name = "Aurora VII",
            planetId = 1,
            launchYear = 2042
        ),
        MissionSeed(
            id = 2,
            name = "Nova Horizon",
            planetId = 1,
            launchYear = 2044
        ),
        MissionSeed(
            id = 3,
            name = "Atlas Prime",
            planetId = 2,
            launchYear = 2046
        ),
        MissionSeed(
            id = 4,
            name = "Celestial Dawn",
            planetId = 2,
            launchYear = 2048
        ),
        MissionSeed(
            id = 5,
            name = "Stellar Path",
            planetId = 2,
            launchYear = 2050
        ),
        MissionSeed(
            id = 6,
            name = "Eclipse Vanguard",
            planetId = 4,
            launchYear = 2052
        ),
        MissionSeed(
            id = 7,
            name = "Nebula Frontier",
            planetId = 4,
            launchYear = 2054
        ),
        MissionSeed(
            id = 8,
            name = "Quantum Odyssey",
            planetId = 3,
            launchYear = 2056
        )
    )

    private val astronauts = listOf(
        AstronautSeed(
            id = 1,
            name = "Luna Carter",
            nationality = "Terran",
            image = "${BASE_IMAGE_URL}Luna_Carter_image_profile.png",
            missionId = 1
        ),
        AstronautSeed(
            id = 2,
            name = "Marcus Vega",
            nationality = "Terran",
            image = "${BASE_IMAGE_URL}Marcus_Vega_image_profile.png",
            missionId = 2
        ),
        AstronautSeed(
            id = 3,
            name = "Ethan Cross",
            nationality = "Terran",
            image = "${BASE_IMAGE_URL}Ethan_Cross_image_profile.png",
            missionId = 3
        ),
        AstronautSeed(
            id = 4,
            name = "Sophia Nova",
            nationality = "Terran",
            image = "${BASE_IMAGE_URL}Sophia_Nova_image_profile.png",
            missionId = 4
        ),
        AstronautSeed(
            id = 5,
            name = "Orion Blake",
            nationality = "Terran",
            image = "${BASE_IMAGE_URL}Orion_Blake_image_profile.png",
            missionId = 5
        ),
        AstronautSeed(
            id = 6,
            name = "Noah Sterling",
            nationality = "Martian",
            image = "${BASE_IMAGE_URL}Noah_Sterling_image_profile.png",
            missionId = 3
        ),
        AstronautSeed(
            id = 7,
            name = "Ava Reynolds",
            nationality = "Lunarian",
            image = null,
            missionId = 6
        ),
        AstronautSeed(
            id = 8,
            name = "Carol Hart",
            nationality = "Terran",
            image = null,
            missionId = 7
        ),
        AstronautSeed(
            id = 9,
            name = "Liam Garry",
            nationality = "Titanian",
            image = null,
            missionId = 7
        ),
        AstronautSeed(
            id = 10,
            name = "Zara Novak",
            nationality = "Europa Colony",
            image = null,
            missionId = 8
        )
    )

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