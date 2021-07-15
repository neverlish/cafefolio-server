package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.CafeLog
import me.cafefolio.server.repository.CafeLogRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CafeLogService(
    val cafeLogRepository: CafeLogRepository,
) {
    fun getOne(id: Int): CafeLog {
        return cafeLogRepository.findByIdOrNull(id)
            ?: throw NotFoundException("CafeLog not found. id: $id")
    }

    fun getList(): List<CafeLog> {
        return cafeLogRepository.findAll()
    }
}