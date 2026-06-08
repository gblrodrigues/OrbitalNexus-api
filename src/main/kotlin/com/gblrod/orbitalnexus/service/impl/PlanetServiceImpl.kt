package com.gblrod.orbitalnexus.service.impl

import com.gblrod.orbitalnexus.model.Planet
import com.gblrod.orbitalnexus.repository.PlanetRepository
import com.gblrod.orbitalnexus.service.PlanetService

class PlanetServiceImpl(
    private val repository: PlanetRepository
) : PlanetService {
    override fun getAll(): List<Planet> {
        return repository.getAll()
    }

    override fun getById(id: Int): Planet? {
        return repository.getById(id)
    }
}