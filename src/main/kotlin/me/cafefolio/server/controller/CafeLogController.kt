package me.cafefolio.server.controller

import me.cafefolio.server.database.CafeLog
import me.cafefolio.server.services.CafeLogService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun get(@PathVariable("id") id: Int): ResponseEntity<CafeLog> {
        try {
            return cafeLogService.getOne(id).let {
                return ResponseEntity.ok(it)
            }
        } catch (error: Exception) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("")
    fun getList(): List<CafeLog> {
        return cafeLogService.getList()
    }
}
