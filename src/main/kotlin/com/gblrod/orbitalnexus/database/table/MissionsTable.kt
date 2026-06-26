package com.gblrod.orbitalnexus.database.table

import org.jetbrains.exposed.v1.core.Table

object MissionsTable : Table(name = "missions") {
    val id = integer(name = "id").autoIncrement()

    val name = varchar(
        name = "name",
        length = 30
    )

    val planetId = integer(name = "planet_id")
    val launchYear = integer(name = "launch_year")

    override val primaryKey = PrimaryKey(firstColumn = id)
}