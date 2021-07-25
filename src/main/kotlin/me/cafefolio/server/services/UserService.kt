package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.User
import me.cafefolio.server.model.http.UserSignupDto
import me.cafefolio.server.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    val userRepository: UserRepository
) {
    fun getByUsername(username: String): User {
        return userRepository.getByUsername(username)
            ?: throw NotFoundException("User not found. username: $username")
    }

    fun create(user: UserSignupDto): User {
        val userByName = userRepository.getByUsername(user.username)

        if (userByName != null) {
            throw Exception("User ${user.username} already exists")
        } else {
            val newUser = User(
                createdAt = LocalDateTime.now(),
                username = user.username,
                password = user.password
            )
            return userRepository.save(newUser)
        }
    }
}
