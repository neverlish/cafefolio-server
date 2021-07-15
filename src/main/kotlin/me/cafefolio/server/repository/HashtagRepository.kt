package me.cafefolio.server.repository

import me.cafefolio.server.database.Hashtag
import org.springframework.data.jpa.repository.JpaRepository

interface HashtagRepository: JpaRepository<Hashtag, Int> {
    fun getByTag(tag: String): Hashtag?
}