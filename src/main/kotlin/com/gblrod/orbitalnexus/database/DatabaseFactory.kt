package com.gblrod.orbitalnexus.database

import io.ktor.server.config.ApplicationConfig
import org.jetbrains.exposed.v1.jdbc.Database

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val config = DatabaseConfig(
        url = config.property("database.url").getString(),
        driver = config.property("database.driver").getString(),
        user = config.property("database.user").getString(),
        password = config.property("database.password").getString()
        )

        Database.connect(
            url = config.url,
            driver = config.driver,
            user = config.user,
            password = config.password
        )

        FlywayFactory.migrate(
            config = config
        )
    }
}