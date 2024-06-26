package com.example.composelearning.network

import com.example.composelearning.db.model.Gym
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GymsApiService {

    @GET("gyms.json")
    suspend fun getGyms(): List<Gym>

    @GET("gyms.json?orderBy=\"id\"")
    suspend fun getGym(@Query("equalTo") id:Int): Map<String, Gym>
}