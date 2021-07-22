package me.cafefolio.server.database

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

@Entity
class CafeLogPhoto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @CreatedDate
    @Column(updatable = false, nullable = false)
    val createdAt: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_log_id")
    val cafeLog: CafeLog,

    @Column(nullable = false)
    val url: String,
)
