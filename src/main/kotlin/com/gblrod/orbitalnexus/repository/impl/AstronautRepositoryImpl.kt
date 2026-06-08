package com.gblrod.orbitalnexus.repository.impl

import com.gblrod.orbitalnexus.database.AstronautsTable
import com.gblrod.orbitalnexus.database.mapper.toAstronaut
import com.gblrod.orbitalnexus.model.Astronaut
import com.gblrod.orbitalnexus.repository.AstronautRepository
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class AstronautRepositoryImpl : AstronautRepository {
    override fun getById(id: Int): Astronaut? {
        return transaction {
            AstronautsTable
                .selectAll()
                .where { AstronautsTable.id eq id }
                .singleOrNull()
                ?.toAstronaut()
        }
    }

    override fun getByMissionId(missionId: Int): List<Astronaut> {
        return transaction {
            AstronautsTable
                .selectAll()
                .where { AstronautsTable.missionId eq missionId }
                .map { it.toAstronaut() }
        }
    }

    override fun getAll(): List<Astronaut> {
        return transaction {
            AstronautsTable
                .selectAll()
                .map { it.toAstronaut() }
        }
    }
}