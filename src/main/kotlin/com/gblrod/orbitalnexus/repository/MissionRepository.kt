package com.gblrod.orbitalnexus.repository

import com.gblrod.orbitalnexus.model.mission.Mission

interface MissionRepository {
    fun getAll(locale: String): List<Mission>
    fun getById(id: Int, locale: String): Mission?
    fun getByPlanetId(planetId: Int, locale: String): List<Mission>
}