package com.gblrod.orbitalnexus.database.mapper

import com.gblrod.orbitalnexus.database.MissionsTable
import com.gblrod.orbitalnexus.model.Mission
import org.jetbrains.exposed.v1.core.ResultRow

fun ResultRow.toMission(): Mission {
    return Mission(
        id = this[MissionsTable.id],
        name = this[MissionsTable.name],
        planetId = this[MissionsTable.planetId],
        launchYear = this[MissionsTable.launchYear]
    )
}