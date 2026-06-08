package com.gblrod.orbitalnexus.database

import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
object DatabaseFactory {
    fun init() {
        Database.connect(
            url = "jdbc:h2:mem:orbitalnexus;DB_CLOSE_DELAY=-1",
            driver = "org.h2.Driver"
        )

        transaction {
            SchemaUtils.create(
                PlanetsTable,
                MissionsTable,
                AstronautsTable
            )
        }

        seed()
    }

    private fun seed() {
        transaction {
            PlanetsTable.insert {
                it[id] = 1
                it[name] = "Kepler Prime"
                it[description] = "Rocky planet located in the Vega sector."
            }

            PlanetsTable.insert {
                it[id] = 2
                it[name] = "Nova Terra"
                it[description] = "Habitable world with vast oceans."
            }

            AstronautsTable.insert {
                it[id] = 1
                it[name] = "Luna Carter"
                it[nationality] = "Terran"
                it[missionId] = 1
            }

            AstronautsTable.insert {
                it[id] = 2
                it[name] = "Marcus Vega"
                it[nationality] = "Terran"
                it[missionId] = 2
            }

            AstronautsTable.insert {
                it[id] = 3
                it[name] = "Ethan Cross"
                it[nationality] = "Terran"
                it[missionId] = 3
            }

            AstronautsTable.insert {
                it[id] = 4
                it[name] = "Sophia Nova"
                it[nationality] = "Terran"
                it[missionId] = 4
            }

            AstronautsTable.insert {
                it[id] = 5
                it[name] = "Orion Blake"
                it[nationality] = "Terran"
                it[missionId] = 5
            }

            MissionsTable.insert {
                it[id] = 1
                it[name] = "Aurora VII"
                it[planetId] = 1
                it[launchYear] = 2042
            }

            MissionsTable.insert {
                it[id] = 2
                it[name] = "Nova Horizon"
                it[planetId] = 1
                it[launchYear] = 2044
            }

            MissionsTable.insert {
                it[id] = 3
                it[name] = "Atlas Prime"
                it[planetId] = 2
                it[launchYear] = 2046
            }

            MissionsTable.insert {
                it[id] = 4
                it[name] = "Celestial Dawn"
                it[planetId] = 2
                it[launchYear] = 2048
            }

            MissionsTable.insert {
                it[id] = 5
                it[name] = "Stellar Path"
                it[planetId] = 2
                it[launchYear] = 2050
            }
        }
    }
}