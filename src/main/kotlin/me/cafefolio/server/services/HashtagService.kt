package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.Hashtag
import me.cafefolio.server.repository.HashtagRepository
import org.springframework.stereotype.Service

@Service
class HashtagService(
    val hashtagRepository: HashtagRepository,
) {
    fun getByTag(tag: String): Hashtag {
        return hashtagRepository.getByTag(tag)
            ?: throw NotFoundException("Hashtag not found. tag: $tag")
    }
}
