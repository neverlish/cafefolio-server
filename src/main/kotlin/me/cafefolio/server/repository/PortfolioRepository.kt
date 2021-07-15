package me.cafefolio.server.repository

import me.cafefolio.server.database.Portfolio
import org.springframework.data.jpa.repository.JpaRepository

interface PortfolioRepository: JpaRepository<Portfolio, Int> {
    fun getByName(name: String): Portfolio?
}