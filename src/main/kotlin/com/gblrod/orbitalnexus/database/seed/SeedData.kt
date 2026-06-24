package com.gblrod.orbitalnexus.database.seed

import com.gblrod.orbitalnexus.database.AstronautsTable
import com.gblrod.orbitalnexus.database.MissionTranslationsTable
import com.gblrod.orbitalnexus.database.MissionsTable
import com.gblrod.orbitalnexus.database.PlanetTranslationsTable
import com.gblrod.orbitalnexus.database.PlanetsTable
import com.gblrod.orbitalnexus.model.mission.MissionTranslation
import com.gblrod.orbitalnexus.model.planet.PlanetTranslation
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

object SeedData {
    private const val BASE_IMAGE_URL = "http://192.168.3.7:8080/assets/astronauts/"

    private val planets = listOf(
        PlanetSeed(
            id = 1,
            name = "Kepler Prime",
            descriptions = listOf(
                PlanetTranslation(locale = "en-US", description = "Rocky planet located in the Vega sector."),
                PlanetTranslation(locale = "pt-BR", description = "Planeta rochoso localizado no setor Vega."),
                PlanetTranslation(locale = "es-ES", description = "Planeta rocoso ubicado en el sector Vega.")
            )
        ),
        PlanetSeed(
            id = 2,
            name = "Nova Terra",
            descriptions = listOf(
                PlanetTranslation(locale = "en-US", description = "Habitable world with vast oceans."),
                PlanetTranslation(locale = "pt-BR", description = "Mundo habitável com vastos oceanos."),
                PlanetTranslation(locale = "es-ES", description = "Un mundo habitable con vastos océanos.")
            )
        ),
        PlanetSeed(
            id = 3,
            name = "Eclipse Haven",
            descriptions = listOf(
                PlanetTranslation(
                    locale = "en-US",
                    description = "Temperate planet surrounded by massive ring systems and rich mineral deposits."
                ),
                PlanetTranslation(
                    locale = "pt-BR",
                    description = "Planeta temperado rodeado por enormes sistemas de anéis e ricos depósitos minerais."
                ),
                PlanetTranslation(
                    locale = "es-ES",
                    description = "Planeta templado rodeado de enormes sistemas de anillos y ricos depósitos minerales."
                )
            )
        ),

        PlanetSeed(
            id = 4,
            name = "Zenith IX",
            descriptions = listOf(
                PlanetTranslation(
                    locale = "en-US",
                    description = "Remote desert world known for its towering crystal formations and extreme climate."
                ),
                PlanetTranslation(
                    locale = "pt-BR",
                    description = "Mundo desértico remoto conhecido por suas imponentes formações cristalinas e clima extremo."
                ),
                PlanetTranslation(
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
            launchYear = 2042,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Survey Kepler Prime and identify suitable landing zones for future expeditions.",
                    description = "The first manned mission to Kepler Prime, focused on planetary mapping and environmental analysis."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Explorar Kepler Prime e identificar áreas de pouso adequadas para futuras expedições.",
                    description = "A primeira missão tripulada a Kepler Prime, com foco no mapeamento planetário e na análise ambiental."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Explorar Kepler Prime e identificar zonas de aterrizaje adecuadas para futuras expediciones.",
                    description = "La primera misión tripulada a Kepler Prime, centrada en la cartografía planetaria y el análisis ambiental."
                ),
            )
        ),
        MissionSeed(
            id = 2,
            name = "Nova Horizon",
            planetId = 1,
            launchYear = 2044,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Establish a permanent research outpost on Kepler Prime.",
                    description = "A follow-up expedition that deployed advanced infrastructure and long-term scientific facilities."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Estabelecer um posto avançado permanente de pesquisa em Kepler Prime.",
                    description = "Uma expedição de acompanhamento que implantou infraestrutura avançada e instalações científicas de longo prazo."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Establecer un puesto avanzado permanente de investigación en Kepler Prime.",
                    description = "Una expedición de seguimiento que desplegó infraestructura avanzada e instalaciones científicas a largo plazo."
                )
            )
        ),

        MissionSeed(
            id = 3,
            name = "Atlas Prime",
            planetId = 2,
            launchYear = 2046,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Assess Nova Terra's habitability and catalog native ecosystems.",
                    description = "A large-scale exploration mission tasked with evaluating Nova Terra as a future settlement candidate."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Avaliar a habitabilidade de Nova Terra e catalogar seus ecossistemas nativos.",
                    description = "Uma missão de exploração em grande escala encarregada de avaliar Nova Terra como candidata a futuros assentamentos."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Evaluar la habitabilidad de Nova Terra y catalogar sus ecosistemas nativos.",
                    description = "Una misión de exploración a gran escala encargada de evaluar Nova Terra como candidata para futuros asentamientos."
                )
            )
        ),

        MissionSeed(
            id = 4,
            name = "Celestial Dawn",
            planetId = 2,
            launchYear = 2048,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Develop the first civilian colony on Nova Terra.",
                    description = "A historic colonization effort that transported settlers, engineers, and agricultural specialists."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Desenvolver a primeira colônia civil em Nova Terra.",
                    description = "Um esforço histórico de colonização que transportou colonos, engenheiros e especialistas em agricultura."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Desarrollar la primera colonia civil en Nova Terra.",
                    description = "Un histórico esfuerzo de colonización que transportó colonos, ingenieros y especialistas agrícolas."
                )
            )
        ),

        MissionSeed(
            id = 5,
            name = "Stellar Path",
            planetId = 2,
            launchYear = 2050,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Expand transportation and communication networks across Nova Terra.",
                    description = "Focused on strengthening infrastructure and supporting the rapid growth of the colony."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Expandir as redes de transporte e comunicação por toda Nova Terra.",
                    description = "Focada no fortalecimento da infraestrutura e no suporte ao rápido crescimento da colônia."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Expandir las redes de transporte y comunicación por toda Nova Terra.",
                    description = "Centrada en fortalecer la infraestructura y apoyar el rápido crecimiento de la colonia."
                )
            )
        ),

        MissionSeed(
            id = 6,
            name = "Eclipse Vanguard",
            planetId = 4,
            launchYear = 2052,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Investigate Zenith IX's crystal formations and mineral resources.",
                    description = "A scientific expedition studying the planet's unique geology and economic potential."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Investigar as formações cristalinas e os recursos minerais de Zenith IX.",
                    description = "Uma expedição científica dedicada ao estudo da geologia singular do planeta e de seu potencial econômico."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Investigar las formaciones cristalinas y los recursos minerales de Zenith IX.",
                    description = "Una expedición científica dedicada al estudio de la geología única del planeta y de su potencial económico."
                )
            )
        ),

        MissionSeed(
            id = 7,
            name = "Nebula Frontier",
            planetId = 4,
            launchYear = 2054,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Establish automated mining operations on Zenith IX.",
                    description = "An industrial mission responsible for deploying extraction systems in extreme desert conditions."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Estabelecer operações automatizadas de mineração em Zenith IX.",
                    description = "Uma missão industrial responsável pela implantação de sistemas de extração em condições desérticas extremas."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Establecer operaciones automatizadas de minería en Zenith IX.",
                    description = "Una misión industrial responsable del despliegue de sistemas de extracción en condiciones desérticas extremas."
                )
            )
        ),

        MissionSeed(
            id = 8,
            name = "Quantum Odyssey",
            planetId = 3,
            launchYear = 2056,
            translations = listOf(
                MissionTranslation(
                    locale = "en-US",
                    missionObjective = "Study anomalous energy signatures detected around Eclipse Haven.",
                    description = "A deep-space research mission investigating unexplained quantum phenomena and their potential applications."
                ),
                MissionTranslation(
                    locale = "pt-BR",
                    missionObjective = "Estudar assinaturas de energia anômalas detectadas ao redor de Eclipse Haven.",
                    description = "Uma missão de pesquisa no espaço profundo que investiga fenômenos quânticos inexplicáveis e suas possíveis aplicações."
                ),
                MissionTranslation(
                    locale = "es-ES",
                    missionObjective = "Estudiar firmas energéticas anómalas detectadas alrededor de Eclipse Haven.",
                    description = "Una misión de investigación en el espacio profundo que estudia fenómenos cuánticos inexplicables y sus posibles aplicaciones."
                )
            )
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