package com.gblrod.orbitalnexus.service

import com.gblrod.orbitalnexus.model.Planet

interface PlanetService {
    fun getAll(locale: String): List<Planet>
    fun getById(id: Int, locale: String): Planet?
}