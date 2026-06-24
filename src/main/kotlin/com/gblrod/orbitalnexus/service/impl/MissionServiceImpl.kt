package com.gblrod.orbitalnexus.service.impl

import com.gblrod.orbitalnexus.model.Astronaut
import com.gblrod.orbitalnexus.model.Mission
import com.gblrod.orbitalnexus.model.Planet
import com.gblrod.orbitalnexus.repository.AstronautRepository
import com.gblrod.orbitalnexus.repository.MissionRepository
import com.gblrod.orbitalnexus.repository.PlanetRepository
import com.gblrod.orbitalnexus.service.MissionService

class MissionServiceImpl(
    private val missionRepository: MissionRepository,
    private val astronautRepository: AstronautRepository,
    private val planetRepository: PlanetRepository
) : MissionService {
    override fun getAll(): List<Mission> {
        return missionRepository.getAll()
    }

    override fun getById(id: Int): Mission? {
        return missionRepository.getById(id)
    }

    override fun getByPlanetId(planetId: Int): List<Mission> {
        return missionRepository.getByPlanetId(planetId)
    }

    override fun getAstronautsByMissionId(missionId: Int): List<Astronaut> {
        return astronautRepository.getByMissionId(missionId)
    }

    override fun getPlanetByMissionId(missionId: Int, locale: String): Planet? {
        val mission = missionRepository.getById(missionId) ?: return null

        return planetRepository.getById(
            id = mission.planetId,
            locale = locale
        )
    }
}