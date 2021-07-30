package me.cafefolio.server.dto

import me.cafefolio.server.database.Cafe

data class CafeDto(
    val id: Int,
    val name: String,
    val address: String,
)

fun Cafe.converToDto(): CafeDto {
    return CafeDto(this.id, this.name, this.address)
}