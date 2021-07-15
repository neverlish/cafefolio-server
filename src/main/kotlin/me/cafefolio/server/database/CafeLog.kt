package me.cafefolio.server.database

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

@Entity
class CafeLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @CreatedDate
    @Column(updatable = false, nullable = false)
    val createdAt: Date,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    val cafe: Cafe,

    @Column(columnDefinition = "text", nullable = false)
    val text: String,
)