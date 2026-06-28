package com.gblrod.orbitalnexus.plugins

import com.gblrod.orbitalnexus.database.table.DatabaseFactory
import io.ktor.server.application.Application

fun Application.configureDatabase() {
    DatabaseFactory.init(environment.config)
}