package me.cafefolio.server.database

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

@Entity
class Hashtag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @CreatedDate
    @Column(updatable = false, nullable = false)
    val createdAt: Date,

    @Column(updatable = false, nullable = false, unique = true)
    val tag: String,

    @ManyToMany
    @JoinTable(name = "cafe_hashtag")
    val cafes: List<Cafe>
)