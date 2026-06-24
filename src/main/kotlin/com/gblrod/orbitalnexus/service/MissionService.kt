package com.gblrod.orbitalnexus.service

import com.gblrod.orbitalnexus.model.Astronaut
import com.gblrod.orbitalnexus.model.Mission
import com.gblrod.orbitalnexus.model.Planet

interface MissionService {
    fun getAll(): List<Mission>
    fun getById(id: Int): Mission?
    fun getByPlanetId(planetId: Int): List<Mission>
    fun getAstronautsByMissionId(missionId: Int): List<Astronaut>
    fun getPlanetByMissionId(missionId: Int, locale: String): Planet?
}