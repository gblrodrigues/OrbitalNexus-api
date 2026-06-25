package com.gblrod.orbitalnexus.database.table

import org.jetbrains.exposed.v1.core.Table

object PlanetTranslationsTable : Table(name = "planet_translations") {
    val planetId = integer(name = "planet_id").references(PlanetsTable.id)

    val locale = varchar(
        name = "locale",
        length = 10
    )

    val description = text(
        name = "description"
    )

    override val primaryKey = PrimaryKey(
        firstColumn = planetId,
        locale
    )
}