package me.cafefolio.server.dto

import me.cafefolio.server.database.User

data class UserDto(
    val id: Int,
    val username: String,
)


fun User.converToDto(): UserDto {
    return UserDto(this.id!!, this.username)
}