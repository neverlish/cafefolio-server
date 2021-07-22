package me.cafefolio.server.controller

import me.cafefolio.server.database.Portfolio
import me.cafefolio.server.services.PortfolioService
import org.springframework.http.ResponseEntity
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
    fun getByName(@PathVariable("name") name: String): ResponseEntity<Portfolio> {
        return portfolioService.getByName(name).let {
            return ResponseEntity.ok(it)
        }
    }
}
