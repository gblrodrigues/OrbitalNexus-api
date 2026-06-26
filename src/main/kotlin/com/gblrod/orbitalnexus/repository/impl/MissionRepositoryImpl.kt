package com.gblrod.orbitalnexus.repository.impl

import com.gblrod.orbitalnexus.database.table.MissionTranslationsTable
import com.gblrod.orbitalnexus.database.table.MissionsTable
import com.gblrod.orbitalnexus.database.mapper.toMission
import com.gblrod.orbitalnexus.model.mission.Mission
import com.gblrod.orbitalnexus.repository.MissionRepository
import org.jetbrains.exposed.v1.core.and
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class MissionRepositoryImpl : MissionRepository {
    override fun getById(id: Int, locale: String): Mission? {
        return transaction {
            (MissionsTable innerJoin MissionTranslationsTable)
                .select(MissionsTable.columns + MissionTranslationsTable.columns)
                .where { (MissionsTable.id eq id) and (MissionTranslationsTable.locale eq locale) }
                .singleOrNull()
                ?.toMission()
        }
    }

    override fun getAll(locale: String): List<Mission> {
        return transaction {
            (MissionsTable innerJoin MissionTranslationsTable)
                .select(MissionsTable.columns + MissionTranslationsTable.columns)
                .where { MissionTranslationsTable.locale eq locale }
                .map { it.toMission() }
        }
    }

    override fun getByPlanetId(
        planetId: Int, locale: String
    ): List<Mission> {
        return transaction {
            (MissionsTable innerJoin MissionTranslationsTable)
                .select(MissionsTable.columns + MissionTranslationsTable.columns)
                .where { (MissionsTable.planetId eq planetId) and (MissionTranslationsTable.locale eq locale) }
                .map { it.toMission() }
        }
    }
}