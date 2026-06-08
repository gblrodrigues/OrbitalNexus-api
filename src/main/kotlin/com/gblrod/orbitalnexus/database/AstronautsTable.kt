package com.gblrod.orbitalnexus.database

import org.jetbrains.exposed.v1.core.Table

object AstronautsTable : Table(name = "astronauts") {
    val id = integer(name = "id").autoIncrement()

    val name = varchar(
        name = "name",
        length = 30
    )

    val nationality = varchar(
        name = "nationality",
        length = 30
    )

    val missionId = integer(name = "mission_id")

    val image = varchar(
        name = "image",
        length = 500
    ).nullable()

    override val primaryKey = PrimaryKey(firstColumn = id)
}