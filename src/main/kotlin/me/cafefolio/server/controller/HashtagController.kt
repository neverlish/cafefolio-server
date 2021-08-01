package me.cafefolio.server.controller

import me.cafefolio.server.dto.HashtagDto
import me.cafefolio.server.services.HashtagService
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
    fun get(@PathVariable("tag") tag: String): HashtagDto {
        return hashtagService.getByTag(tag)
    }
}
