package me.cafefolio.server.controller

import me.cafefolio.server.dto.UserDto
import me.cafefolio.server.model.http.UserSignupDto
import me.cafefolio.server.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    val userService: UserService,
) {
    @GetMapping("/{username}")
    fun getByUsername(@PathVariable("username") username: String): ResponseEntity<UserDto> {
        try {
            return userService.getByUsername(username).let {
                return ResponseEntity.ok(it)
            }
        } catch (error: Exception) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/signup")
    fun signup(@Validated @RequestBody userSignupDto: UserSignupDto): UserDto {
        return userService.create(userSignupDto)
    }
}
