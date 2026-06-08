package com.gblrod.orbitalnexus.database

import org.jetbrains.exposed.v1.core.Table

object PlanetsTable : Table(name = "planets") {
    val id = integer(name = "id").autoIncrement()

    val name = varchar(
        name = "name",
        length = 30
    )

    val description = text(name = "description")

    override val primaryKey = PrimaryKey(firstColumn = id)
}