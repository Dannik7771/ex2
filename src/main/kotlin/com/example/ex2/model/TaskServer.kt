package com.example.ex2.model

import jakarta.persistence.*

@Entity
@Table
data class TaskServer(
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long,
    val util: Float = 0.00f,
    val overall_size: Int = 128,
    @OneToMany
    val machines: MutableList<Machine> = mutableListOf()
)
