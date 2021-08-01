package me.cafefolio.server.controller

import me.cafefolio.server.dto.UserDto
import me.cafefolio.server.model.http.UserSignupDto
import me.cafefolio.server.services.UserService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    val userService: UserService,
) {
    @GetMapping("/{username}")
    fun getByUsername(@PathVariable("username") username: String): UserDto {
        return userService.getByUsername(username)
    }

    @PostMapping("/signup")
    fun signup(@Validated @RequestBody userSignupDto: UserSignupDto): UserDto {
        return userService.create(userSignupDto)
    }
}
