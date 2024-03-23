package com.example.composelearning.network

import com.example.composelearning.db.model.Gym
import retrofit2.Call
import retrofit2.http.GET

interface GymsApiService {

    @GET("gyms.json")
    fun getGyms(): Call<List<Gym>>
}