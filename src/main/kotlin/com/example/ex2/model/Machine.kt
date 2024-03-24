package com.example.ex2.model

import jakarta.persistence.*

@Entity
@Table
data class Machine (
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long,
    val size: Int,
    val task: String
)