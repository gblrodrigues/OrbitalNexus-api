package com.gblrod.orbitalnexus.plugins

import com.gblrod.orbitalnexus.di.AppModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(AppModule)
    }
}