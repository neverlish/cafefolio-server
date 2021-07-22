package me.cafefolio.server.services

import javassist.NotFoundException
import me.cafefolio.server.database.Cafe
import me.cafefolio.server.repository.CafeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CafeService(
    val cafeRepository: CafeRepository,
) {
    fun getOne(id: Int): Cafe {
        return cafeRepository.findByIdOrNull(id)
            ?: throw NotFoundException("Cafe not found. id: $id")
    }
}
