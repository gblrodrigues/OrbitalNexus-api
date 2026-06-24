package com.gblrod.orbitalnexus.service.impl

import com.gblrod.orbitalnexus.model.Planet
import com.gblrod.orbitalnexus.repository.PlanetRepository
import com.gblrod.orbitalnexus.service.PlanetService
import com.gblrod.orbitalnexus.util.Locales

class PlanetServiceImpl(
    private val repository: PlanetRepository
) : PlanetService {
    override fun getAll(locale: String): List<Planet> {
        val planets = repository.getAll(locale)

        if (planets.isNotEmpty()) {
            return planets
        }

        return repository.getAll(locale = Locales.DEFAULT)
    }

    override fun getById(id: Int, locale: String): Planet? {
        return repository.getById(id, locale) ?: repository.getById(id = id, locale = Locales.DEFAULT)
    }
}