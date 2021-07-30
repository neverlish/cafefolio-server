package me.cafefolio.server.dto

import me.cafefolio.server.database.Portfolio

data class PortfolioDto(
    val id: Int,
    val user: UserDto,
    val name: String,
    val cafes: List<CafeDto>,
)

fun Portfolio.converToDto(): PortfolioDto {
    return PortfolioDto(
        this.id,
        this.user.converToDto(),
        this.name,
        this.cafes.map { it.converToDto() },
    )
}