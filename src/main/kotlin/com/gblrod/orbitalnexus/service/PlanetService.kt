package com.gblrod.orbitalnexus.service

import com.gblrod.orbitalnexus.model.Planet

interface PlanetService {
    fun getAll(): List<Planet>
    fun getById(id: Int): Planet?
}