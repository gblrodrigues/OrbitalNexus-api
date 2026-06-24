package com.gblrod.orbitalnexus.database

import com.gblrod.orbitalnexus.database.seed.SeedData
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
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
                PlanetTranslationsTable,
                MissionsTable,
                MissionTranslationsTable,
                AstronautsTable
            )
        }

        SeedData.populate()
    }
}