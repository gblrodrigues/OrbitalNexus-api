package com.gblrod.orbitalnexus.repository

import com.gblrod.orbitalnexus.model.astronaut.Astronaut

interface AstronautRepository {
    fun getAll(): List<Astronaut>
    fun getById(id: Int): Astronaut?
    fun getByMissionId(missionId: Int): List<Astronaut>
}