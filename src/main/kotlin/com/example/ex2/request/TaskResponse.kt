package com.example.ex2.request

data class TaskResponseFailure(
    val result: String = "NOT_OK"
)

data class TaskResponseSuccessful(
    val result: String = "OK",
    val host_id: Long
)
