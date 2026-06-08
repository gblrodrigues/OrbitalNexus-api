package com.gblrod.orbitalnexus.repository.impl

import com.gblrod.orbitalnexus.database.PlanetsTable
import com.gblrod.orbitalnexus.database.mapper.toPlanet
import com.gblrod.orbitalnexus.model.Planet
import com.gblrod.orbitalnexus.repository.PlanetRepository
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class PlanetRepositoryImpl : PlanetRepository {
    override fun getById(id: Int): Planet? {
        return transaction {
            PlanetsTable
                .selectAll()
                .where { PlanetsTable.id eq id }
                .singleOrNull()
                ?.toPlanet()
        }
    }

    override fun getAll(): List<Planet> {
        return transaction {
            PlanetsTable
                .selectAll()
                .map { it.toPlanet() }
        }
    }
}