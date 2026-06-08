package com.gblrod.orbitalnexus.database.mapper

import com.gblrod.orbitalnexus.database.AstronautsTable
import com.gblrod.orbitalnexus.model.Astronaut
import org.jetbrains.exposed.v1.core.ResultRow

fun ResultRow.toAstronaut(): Astronaut {
    return Astronaut(
        id = this[AstronautsTable.id],
        name = this[AstronautsTable.name],
        nationality = this[AstronautsTable.nationality],
        missionId = this[AstronautsTable.missionId],
        image = this[AstronautsTable.image]
    )
}