package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.dto.PortfolioDto
import me.cafefolio.server.dto.converToDto
import me.cafefolio.server.repository.PortfolioRepository
import org.springframework.stereotype.Service

@Service
class PortfolioService(
    val portfolioRepository: PortfolioRepository,
) {
    fun getByName(name: String): PortfolioDto {
        return portfolioRepository.getByName(name)?.let { it.converToDto() }
            ?: throw NotFoundException("Portfolio not found. name: $name")
    }
}
