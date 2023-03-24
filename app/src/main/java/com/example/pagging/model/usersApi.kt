package com.example.pagging.model

data class usersApi(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)