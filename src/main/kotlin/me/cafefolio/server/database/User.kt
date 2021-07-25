package me.cafefolio.server.database

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @CreatedDate
    @Column(updatable = false, nullable = false)
    val createdAt: LocalDateTime,

    @Column(unique = true, nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,
)
