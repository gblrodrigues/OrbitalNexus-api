package com.gblrod.orbitalnexus.database.table

import com.gblrod.orbitalnexus.database.seed.SeedData
import io.ktor.server.config.*
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val url = config.property("database.url").getString()
        val driver = config.property("database.driver").getString()
        val user = config.property("database.user").getString()
        val password = config.property("database.password").getString()

        Database.connect(
            url = url,
            driver = driver,
            user = user,
            password = password
        )

        transaction {
            SchemaUtils.create(
                PlanetsTable,
                PlanetTranslationsTable,
                MissionsTable,
                MissionTranslationsTable,
                AstronautsTable
            )

            if (PlanetsTable.selectAll().limit(count = 1).empty()) {
                SeedData.populate()
            }
        }
    }
}