package com.gblrod.orbitalnexus.service

import com.gblrod.orbitalnexus.model.astronaut.Astronaut
import com.gblrod.orbitalnexus.model.mission.Mission
import com.gblrod.orbitalnexus.model.planet.Planet

interface MissionService {
    fun getAll(locale: String): List<Mission>
    fun getById(id: Int, locale: String): Mission?
    fun getByPlanetId(planetId: Int, locale: String): List<Mission>
    fun getAstronautsByMissionId(missionId: Int): List<Astronaut>
    fun getPlanetByMissionId(missionId: Int, locale: String): Planet?
}