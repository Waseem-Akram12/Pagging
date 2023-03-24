package com.example.pagging.retrofit

import com.example.pagging.Utils.ApiLink
import com.example.pagging.model.usersApi
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofitapi {
    @GET("/users")
    suspend fun getQuotes(@Query("page") page: Int): usersApi
}