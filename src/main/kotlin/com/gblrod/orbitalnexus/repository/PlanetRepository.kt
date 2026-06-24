package com.gblrod.orbitalnexus.repository

import com.gblrod.orbitalnexus.model.planet.Planet

interface PlanetRepository {
    fun getAll(locale: String): List<Planet>
    fun getById(id: Int, locale: String): Planet?
}