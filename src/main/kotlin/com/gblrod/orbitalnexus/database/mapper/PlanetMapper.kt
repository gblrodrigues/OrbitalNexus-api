package com.gblrod.orbitalnexus.database.mapper

import com.gblrod.orbitalnexus.database.PlanetsTable
import com.gblrod.orbitalnexus.model.Planet
import org.jetbrains.exposed.v1.core.ResultRow

fun ResultRow.toPlanet(): Planet {
    return Planet(
        id = this[PlanetsTable.id],
        name = this[PlanetsTable.name],
        description = this[PlanetsTable.description]
    )
}