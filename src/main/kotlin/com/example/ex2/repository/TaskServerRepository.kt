package com.example.ex2.repository

import com.example.ex2.model.TaskServer
import org.springframework.data.jpa.repository.JpaRepository

interface TaskServerRepository: JpaRepository<TaskServer, Long> {
}