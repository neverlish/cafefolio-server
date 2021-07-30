package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.dto.CafeDto
import me.cafefolio.server.dto.converToDto
import me.cafefolio.server.repository.CafeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CafeService(
    val cafeRepository: CafeRepository,
) {
    fun getOne(id: Int): CafeDto {
        return cafeRepository.findByIdOrNull(id)?.let { it.converToDto() }
            ?: throw NotFoundException("Cafe not found. id: $id")
    }
}
