package me.cafefolio.server.controller

import me.cafefolio.server.dto.PortfolioDto
import me.cafefolio.server.services.PortfolioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/portfolios")
class PortfolioController(
    val portfolioService: PortfolioService,
) {
    @GetMapping("/{name}")
    fun getByName(@PathVariable("name") name: String): PortfolioDto {
        return portfolioService.getByName(name)

    }
}
