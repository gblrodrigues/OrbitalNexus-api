package com.gblrod.orbitalnexus.database

import org.flywaydb.core.Flyway

object FlywayFactory {
    fun migrate(config: DatabaseConfig) {
        Flyway.configure()
            .dataSource(
                config.url,
                config.user,
                config.password
            )
            .load()
            .migrate()
    }
}
