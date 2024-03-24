package com.example.ex2.service

import com.example.ex2.model.Machine
import com.example.ex2.model.TaskServer
import com.example.ex2.repository.MachineRepository
import com.example.ex2.repository.TaskServerRepository
import com.example.ex2.request.TaskRequest
import com.example.ex2.request.TaskResponseFailure
import com.example.ex2.request.TaskResponseSuccessful
import org.springframework.stereotype.Service

@Service
class TaskService(
    val serverRep: TaskServerRepository,
    val machineRep: MachineRepository
) {
    fun executeTask(taskRequest: TaskRequest): Any {
        val servers = serverRep.findAll()
        var serverFound: TaskServer? = null
        var minUtil = 1.00f
        for (server in servers) {
            if (server.util < minUtil
                && (1-server.util)*128 > taskRequest.size) {
                minUtil = server.util
                serverFound = server
            }
        }
        if (serverFound == null)
            return TaskResponseFailure()

        var duplicate = 0
        serverFound.machines.forEach { if (it.id == taskRequest.id) duplicate ++}
        if (duplicate>0)
            return TaskResponseFailure()

        val machineFound = Machine(taskRequest.id, taskRequest.size, taskRequest.task)
        machineRep.save(machineFound)
        serverFound.machines.add(machineFound)
        serverRep.save(serverFound)
        return TaskResponseSuccessful(host_id=serverFound.id)
    }

    fun postServer(taskServer: TaskServer): TaskServer {
        return serverRep.save(taskServer)
    }
}