package me.cafefolio.server.repository

import me.cafefolio.server.database.Cafe
import org.springframework.data.jpa.repository.JpaRepository

interface CafeRepository: JpaRepository<Cafe, Int>