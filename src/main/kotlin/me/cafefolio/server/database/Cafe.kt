package me.cafefolio.server.database

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

@Entity
class Cafe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @CreatedDate
    @Column(updatable = false, nullable = false)
    val createdAt: Date,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val address: String,
)
