package me.cafefolio.server.services

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.mockk
import javassist.NotFoundException
import me.cafefolio.server.database.Hashtag
import me.cafefolio.server.repository.HashtagRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class HashtagServiceTest {
    private val hashtagRepository: HashtagRepository = mockk()

    @InjectMockKs
    lateinit var hashtagService: HashtagService

    @BeforeEach
    fun beforeEach() {
        clearAllMocks()
        MockKAnnotations.init(this)
    }

    @Nested
    inner class GetByTagTest {
        val tag = "good"
        val id = 2

        @Test
        fun `find Hashtag by tag and return result`() {
            every {
                hashtagRepository.getByTag(tag)
            } returns mockk<Hashtag>(relaxed = true).also {
                every { it.id } returns id
            }

            val result = hashtagService.getByTag(tag)
            assertEquals(result.id, id)
        }

        @Test
        fun `throw error when Hashtag by tag not exists`() {
            every {
                hashtagRepository.getByTag(tag)
            } returns null

            assertThrows<NotFoundException> {
                hashtagService.getByTag(tag)
            }
        }
    }
}