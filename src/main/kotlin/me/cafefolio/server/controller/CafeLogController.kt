package me.cafefolio.server.controller

import me.cafefolio.server.dto.CafeLogDto
import me.cafefolio.server.services.CafeLogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cafe-logs")
class CafeLogController(
    val cafeLogService: CafeLogService,
) {
    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int): CafeLogDto {
        return cafeLogService.getOne(id)
    }

    @GetMapping("")
    fun getList(): List<CafeLogDto> {
        return cafeLogService.getList()
    }
}
