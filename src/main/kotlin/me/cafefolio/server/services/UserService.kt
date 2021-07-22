package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.User
import me.cafefolio.server.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository
) {
    fun getByUsername(username: String): User {
        return userRepository.getByUsername(username)
            ?: throw NotFoundException("User not found. username: $username")
    }
}
