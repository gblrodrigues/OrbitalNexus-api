package com.gblrod.orbitalnexus.service.impl

import com.gblrod.orbitalnexus.model.astronaut.Astronaut
import com.gblrod.orbitalnexus.model.mission.Mission
import com.gblrod.orbitalnexus.model.planet.Planet
import com.gblrod.orbitalnexus.repository.AstronautRepository
import com.gblrod.orbitalnexus.repository.MissionRepository
import com.gblrod.orbitalnexus.repository.PlanetRepository
import com.gblrod.orbitalnexus.service.MissionService
import com.gblrod.orbitalnexus.util.Locales

class MissionServiceImpl(
    private val missionRepository: MissionRepository,
    private val astronautRepository: AstronautRepository,
    private val planetRepository: PlanetRepository
) : MissionService {
    override fun getAll(locale: String): List<Mission> {
        val missions = missionRepository.getAll(locale)

        if (missions.isNotEmpty()) {
            return missions
        }

        return missionRepository.getAll(locale = Locales.DEFAULT)
    }

    override fun getById(id: Int, locale: String): Mission? {
        return missionRepository.getById(id, locale) ?: missionRepository.getById(id, Locales.DEFAULT)
    }

    override fun getByPlanetId(planetId: Int, locale: String): List<Mission> {
        val missions = missionRepository.getByPlanetId(planetId, locale)

        if (missions.isNotEmpty()) {
            return missions
        }

        return missionRepository.getByPlanetId(planetId, Locales.DEFAULT)
    }

    override fun getAstronautsByMissionId(missionId: Int): List<Astronaut> {
        return astronautRepository.getByMissionId(missionId)
    }

    override fun getPlanetByMissionId(missionId: Int, locale: String): Planet? {
        val mission = getById(missionId, locale) ?: return null

        return planetRepository.getById(id = mission.planetId, locale = locale)
    }
}