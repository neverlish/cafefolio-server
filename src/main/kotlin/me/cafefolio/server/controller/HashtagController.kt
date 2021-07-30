package me.cafefolio.server.controller

import me.cafefolio.server.dto.HashtagDto
import me.cafefolio.server.services.HashtagService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hashtags")
class HashtagController(
    val hashtagService: HashtagService,
) {
    @GetMapping("/{tag}")
    fun get(@PathVariable("tag") tag: String): ResponseEntity<HashtagDto> {
        try {
            return hashtagService.getByTag(tag).let {
                return ResponseEntity.ok(it)
            }
        } catch (error: Exception) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }
}
