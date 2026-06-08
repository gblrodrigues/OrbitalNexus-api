package com.gblrod.orbitalnexus.repository

import com.gblrod.orbitalnexus.model.Mission

interface MissionRepository {
    fun getAll(): List<Mission>
    fun getById(id: Int): Mission?
    fun getByPlanetId(planetId: Int): List<Mission>
}