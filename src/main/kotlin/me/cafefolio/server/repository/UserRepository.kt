package me.cafefolio.server.repository

import me.cafefolio.server.database.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun getByEmail(email: String): User?
}