package com.gblrod.orbitalnexus.repository.impl

import com.gblrod.orbitalnexus.database.PlanetTranslationsTable
import com.gblrod.orbitalnexus.database.PlanetsTable
import com.gblrod.orbitalnexus.database.mapper.toPlanet
import com.gblrod.orbitalnexus.model.planet.Planet
import com.gblrod.orbitalnexus.repository.PlanetRepository
import org.jetbrains.exposed.v1.core.and
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class PlanetRepositoryImpl : PlanetRepository {
    override fun getById(id: Int, locale: String): Planet? {
        return transaction {
            (PlanetsTable innerJoin PlanetTranslationsTable)
                .select(PlanetsTable.columns + PlanetTranslationsTable.columns)
                .where { (PlanetsTable.id eq id) and (PlanetTranslationsTable.locale eq locale) }
                .singleOrNull()
                ?.toPlanet()
        }
    }

    override fun getAll(locale: String): List<Planet> {
        return transaction {
            (PlanetsTable innerJoin PlanetTranslationsTable)
                .select(PlanetsTable.columns + PlanetTranslationsTable.columns)
                .where { PlanetTranslationsTable.locale eq locale }
                .map { it.toPlanet() }
        }
    }
}