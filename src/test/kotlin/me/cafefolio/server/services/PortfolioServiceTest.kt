package me.cafefolio.server.services

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import javassist.NotFoundException
import me.cafefolio.server.database.Portfolio
import me.cafefolio.server.repository.PortfolioRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PortfolioServiceTest {
    private val portfolioRepository: PortfolioRepository = mockk()

    @InjectMockKs
    lateinit var portfolioService: PortfolioService

    @BeforeEach
    fun beforeEach() {
        clearAllMocks()
        MockKAnnotations.init(this)
    }

    @Nested
    inner class GetByNameTest {
        val name = "mine"
        val id = 2

        @Test
        fun `find Portfolio by name and return result`() {
            every {
                portfolioRepository.getByName(name)
            } returns mockk<Portfolio>(relaxed = true).also {
                every { it.id } returns id
            }

            val result = portfolioService.getByName(name)
            assertEquals(result.id, id)
        }

        @Test
        fun `throw error when Portfolio by name not exists`() {
            every {
                portfolioRepository.getByName(name)
            } returns null

            assertThrows<NotFoundException> {
                portfolioService.getByName(name)
            }
        }
    }
}