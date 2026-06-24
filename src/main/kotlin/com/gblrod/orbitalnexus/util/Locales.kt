package com.gblrod.orbitalnexus.util

import com.gblrod.orbitalnexus.util.Locales.DEFAULT
import com.gblrod.orbitalnexus.util.Locales.SUPPORTED
import io.ktor.server.application.ApplicationCall

object Locales {
    const val DEFAULT = "en-US"

    val SUPPORTED = setOf(
        "en-US",
        "pt-BR",
        "es-ES"
    )
}

fun resolveLocale(locale: String?): String {
    return locale?.takeIf {
        it in SUPPORTED
    } ?: DEFAULT
}

fun ApplicationCall.locale(): String {
    return resolveLocale(
        request.queryParameters["lang"]
    )
}