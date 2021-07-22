package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.Portfolio
import me.cafefolio.server.repository.PortfolioRepository
import org.springframework.stereotype.Service

@Service
class PortfolioService(
    val portfolioRepository: PortfolioRepository,
) {
    fun getByName(name: String): Portfolio {
        return portfolioRepository.getByName(name)
            ?: throw NotFoundException("Portfolio not found. name: $name")
    }
}
