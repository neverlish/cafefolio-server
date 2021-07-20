package me.cafefolio.server.services

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import javassist.NotFoundException
import me.cafefolio.server.database.User
import me.cafefolio.server.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class UserServiceTest {
    private val userRepository: UserRepository = mockk()

    @InjectMockKs
    lateinit var userService: UserService

    @BeforeEach
    fun beforeEach() {
        clearAllMocks()
        MockKAnnotations.init(this)
    }

    @Nested
    inner class GetByEmailTest {
        val username = "test@email"
        val id = 2

        @Test
        fun `find User by username and return result`() {
            every {
                userRepository.getByUsername(username)
            } returns mockk<User>(relaxed = true).also {
                every { it.id } returns id
            }

            val result = userService.getByUsername(username)
            assertEquals(result.id, id)
        }

        @Test
        fun `throw error when User by username not exists`() {
            every {
                userRepository.getByUsername(username)
            } returns null

            assertThrows<NotFoundException> {
                userService.getByUsername(username)
            }
        }
    }
}