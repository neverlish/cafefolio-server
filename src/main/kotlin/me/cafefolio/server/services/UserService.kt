package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.User
import me.cafefolio.server.dto.UserDto
import me.cafefolio.server.dto.converToDto
import me.cafefolio.server.model.http.UserSignupDto
import me.cafefolio.server.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    val userRepository: UserRepository
) {
    fun getByUsername(username: String): UserDto {
        return userRepository.getByUsername(username)
            ?.let { it.converToDto() }
            ?: throw NotFoundException("User not found. username: $username")
    }

    fun create(user: UserSignupDto): UserDto {
        val userByName = userRepository.getByUsername(user.username)

        if (userByName != null) {
            throw Exception("User ${user.username} already exists")
        } else {
            val newUser = User(
                createdAt = LocalDateTime.now(),
                username = user.username,
                password = user.password
            )
            val created = userRepository.save(newUser)

            return created.converToDto()
        }
    }
}
