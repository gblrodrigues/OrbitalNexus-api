package com.gblrod.orbitalnexus.database.mapper

import com.gblrod.orbitalnexus.database.table.MissionTranslationsTable
import com.gblrod.orbitalnexus.database.table.MissionsTable
import com.gblrod.orbitalnexus.model.mission.Mission
import org.jetbrains.exposed.v1.core.ResultRow

fun ResultRow.toMission(): Mission {
    return Mission(
        id = this[MissionsTable.id],
        name = this[MissionsTable.name],
        missionObjective = this[MissionTranslationsTable.missionObjective],
        description = this[MissionTranslationsTable.description],
        planetId = this[MissionsTable.planetId],
        launchYear = this[MissionsTable.launchYear]
    )
}