package me.cafefolio.server.dto

import me.cafefolio.server.database.CafeLogPhoto

data class CafeLogPhotoDto(
    val cafeLog: CafeLogDto,
    val url: String,
)

fun CafeLogPhoto.converToDto(): CafeLogPhotoDto {
    return CafeLogPhotoDto(this.cafeLog.converToDto(), this.url)
}