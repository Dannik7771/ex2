package com.example.ex2.controller

import com.example.ex2.model.Machine
import com.example.ex2.model.TaskServer
import com.example.ex2.request.TaskRequest
import com.example.ex2.service.TaskService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
    val service: TaskService
) {
    @PostMapping("/add")
    fun postServer(@RequestBody taskServer: TaskServer): TaskServer {
        return service.postServer(taskServer)
    }

    @PostMapping
    fun executeTask(@RequestBody taskRequest: TaskRequest) : Any {
        return service.executeTask(taskRequest)
    }
}