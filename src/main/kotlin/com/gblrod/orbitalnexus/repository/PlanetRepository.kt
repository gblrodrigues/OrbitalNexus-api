package com.gblrod.orbitalnexus.repository

import com.gblrod.orbitalnexus.model.Planet

interface PlanetRepository {
    fun getAll(): List<Planet>
    fun getById(id: Int): Planet?
}