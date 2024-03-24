package com.example.ex2.repository

import com.example.ex2.model.Machine
import org.springframework.data.jpa.repository.JpaRepository

interface MachineRepository: JpaRepository<Machine, Long> {
}