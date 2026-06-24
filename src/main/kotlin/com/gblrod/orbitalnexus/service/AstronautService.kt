package com.gblrod.orbitalnexus.service

import com.gblrod.orbitalnexus.model.astronaut.Astronaut

interface AstronautService {
    fun getAll(): List<Astronaut>
    fun getById(id: Int): Astronaut?
    fun getByMissionId(missionId: Int): List<Astronaut>
}