package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.dto.HashtagDto
import me.cafefolio.server.dto.converToDto
import me.cafefolio.server.repository.HashtagRepository
import org.springframework.stereotype.Service

@Service
class HashtagService(
    val hashtagRepository: HashtagRepository,
) {
    fun getByTag(tag: String): HashtagDto {
        return hashtagRepository.getByTag(tag)?.let { it.converToDto() }
            ?: throw NotFoundException("Hashtag not found. tag: $tag")
    }
}
