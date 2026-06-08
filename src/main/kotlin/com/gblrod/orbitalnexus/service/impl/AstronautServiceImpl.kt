package com.gblrod.orbitalnexus.service.impl

import com.gblrod.orbitalnexus.model.Astronaut
import com.gblrod.orbitalnexus.repository.AstronautRepository
import com.gblrod.orbitalnexus.service.AstronautService

class AstronautServiceImpl(
    private val repository: AstronautRepository
) : AstronautService {
    override fun getAll(): List<Astronaut> {
        return repository.getAll()
    }

    override fun getById(id: Int): Astronaut? {
        return repository.getById(id)
    }

    override fun getByMissionId(
        missionId: Int
    ): List<Astronaut> {
        return repository.getByMissionId(missionId)
    }
}