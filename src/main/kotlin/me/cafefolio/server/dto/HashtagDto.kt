package me.cafefolio.server.dto

import me.cafefolio.server.database.Hashtag

data class HashtagDto(
    val tag: String,
    val cafes: List<CafeDto>,
)

fun Hashtag.converToDto(): HashtagDto {
    return HashtagDto(this.tag, this.cafes.map { it.converToDto() })
}