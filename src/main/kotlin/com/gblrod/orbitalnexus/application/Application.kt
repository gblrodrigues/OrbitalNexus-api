package com.gblrod.orbitalnexus.application

import com.gblrod.orbitalnexus.database.DatabaseFactory
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    DatabaseFactory.init()
    EngineMain.main(args)
}