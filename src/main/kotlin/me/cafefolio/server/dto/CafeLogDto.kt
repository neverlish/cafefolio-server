package me.cafefolio.server.dto

import me.cafefolio.server.database.CafeLog

data class CafeLogDto(
    val id: Int,
    val user: UserDto,
    val cafe: CafeDto,
    val text: String,
)

fun CafeLog.converToDto(): CafeLogDto {
    return CafeLogDto(
        this.id,
        this.user.converToDto(),
        this.cafe.converToDto(),
        this.text,
    )
}