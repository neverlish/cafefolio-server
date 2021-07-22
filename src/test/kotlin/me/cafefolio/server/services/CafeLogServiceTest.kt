package me.cafefolio.server.services

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import javassist.NotFoundException
import me.cafefolio.server.database.CafeLog
import me.cafefolio.server.repository.CafeLogRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.repository.findByIdOrNull

internal class CafeLogServiceTest {
    private val cafeLogRepository: CafeLogRepository = mockk()

    @InjectMockKs
    lateinit var cafeLogService: CafeLogService

    @BeforeEach
    fun beforeEach() {
        clearAllMocks()
        MockKAnnotations.init(this)
    }

    @Nested
    inner class GetOneTest {
        val id = 1
        val text = "123"

        @Test
        fun `find CafeLog by id and return result`() {
            every {
                cafeLogRepository.findByIdOrNull(id)
            } returns mockk<CafeLog>(relaxed = true).also {
                every { it.text } returns text
            }

            val result = cafeLogService.getOne(id)
            assertEquals(result.text, text)
        }

        @Test
        fun `throw error when Cafelog by id not exists`() {
            every {
                cafeLogRepository.findByIdOrNull(id)
            } returns null

            assertThrows<NotFoundException> {
                cafeLogService.getOne(id)
            }
        }
    }

    @Nested
    inner class GetListTest {
        @Test
        fun `return all records of CafeLog`() {
            every {
                cafeLogRepository.findAll()
            } returns listOf(
                mockk<CafeLog>(relaxed = true),
                mockk<CafeLog>(relaxed = true),
            )

            val result = cafeLogService.getList()
            assertEquals(result.size, 2)
        }
    }
}
