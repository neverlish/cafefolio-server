package me.cafefolio.server.services

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import javassist.NotFoundException
import me.cafefolio.server.database.Cafe
import me.cafefolio.server.repository.CafeRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.repository.findByIdOrNull

internal class CafeServiceTest {
    private val cafeRepository: CafeRepository = mockk()

    @InjectMockKs
    lateinit var cafeService: CafeService

    @BeforeEach
    fun beforeEach() {
        clearAllMocks()
        MockKAnnotations.init(this)
    }

    @Nested
    inner class GetOneTest {
        val id = 1
        val name = "CAFE!"

        @Test
        fun `find Cafe by id and return result`() {
            every {
                cafeRepository.findByIdOrNull(id)
            } returns mockk<Cafe>(relaxed = true).also {
                every { it.name } returns name
            }

            val result = cafeService.getOne(id)
            assertEquals(result.name, name)
        }

        @Test
        fun `throw error when Cafe by id not exists`() {
            every {
                cafeRepository.findByIdOrNull(id)
            } returns null

            assertThrows<NotFoundException> {
                cafeService.getOne(id)
            }
        }
    }
}
