package me.cafefolio.server.repository

import me.cafefolio.server.database.CafeLog
import org.springframework.data.jpa.repository.JpaRepository

interface CafeLogRepository : JpaRepository<CafeLog, Int>
