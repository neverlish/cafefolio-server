package me.cafefolio.server.controller

import me.cafefolio.server.database.User
import me.cafefolio.server.model.http.UserSignupDto
import me.cafefolio.server.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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

    @PostMapping("/signup")
    fun signup(@Validated @RequestBody userSignupDto: UserSignupDto): User {
        return userService.create(userSignupDto)
    }
}
