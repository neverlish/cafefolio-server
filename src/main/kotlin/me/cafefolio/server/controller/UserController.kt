package me.cafefolio.server.controller

import me.cafefolio.server.database.User
import me.cafefolio.server.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    val userService: UserService,
) {
    @GetMapping("/{username}")
    fun getByUsername(@PathVariable("username") username: String): ResponseEntity<User> {
        return userService.getByUsername(username).let {
            return ResponseEntity.ok(it)
        }
    }
}
