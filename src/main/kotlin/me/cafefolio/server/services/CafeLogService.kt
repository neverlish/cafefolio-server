package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.dto.CafeLogDto
import me.cafefolio.server.dto.converToDto
import me.cafefolio.server.repository.CafeLogRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CafeLogService(
    val cafeLogRepository: CafeLogRepository,
) {
    fun getOne(id: Int): CafeLogDto {
        return cafeLogRepository.findByIdOrNull(id)?.let { it.converToDto() }
            ?: throw NotFoundException("CafeLog not found. id: $id")
    }

    fun getList(): List<CafeLogDto> {
        return cafeLogRepository.findAll().map { it.converToDto() }
    }
}
