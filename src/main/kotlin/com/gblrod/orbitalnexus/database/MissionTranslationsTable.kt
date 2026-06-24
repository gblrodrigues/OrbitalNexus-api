package com.gblrod.orbitalnexus.database

import org.jetbrains.exposed.v1.core.Table

object MissionTranslationsTable : Table(name = "mission_translations") {
    val missionId = integer(name = "mission_id").references(MissionsTable.id)

    val locale = varchar(
        name = "locale",
        length = 10
    )

    val missionObjective = text(
        name = "missionObjective"
    )

    val description = text(
        name = "description"
    )

    override val primaryKey = PrimaryKey(
        firstColumn = missionId,
        locale
    )
}