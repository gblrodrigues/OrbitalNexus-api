package com.gblrod.orbitalnexus.repository.impl

import com.gblrod.orbitalnexus.database.MissionsTable
import com.gblrod.orbitalnexus.database.mapper.toMission
import com.gblrod.orbitalnexus.model.Mission
import com.gblrod.orbitalnexus.repository.MissionRepository
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class MissionRepositoryImpl : MissionRepository {
    override fun getById(id: Int): Mission? {
        return transaction {
            MissionsTable
                .selectAll()
                .where { MissionsTable.id eq id }
                .singleOrNull()
                ?.toMission()
        }
    }

    override fun getAll(): List<Mission> {
        return transaction {
            MissionsTable
                .selectAll()
                .map { it.toMission() }
        }
    }

    override fun getByPlanetId(
        planetId: Int
    ): List<Mission> {
        return transaction {
            MissionsTable
                .selectAll()
                .where { MissionsTable.planetId eq planetId }
                .map { it.toMission() }
        }
    }
}