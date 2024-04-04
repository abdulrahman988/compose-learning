package com.example.composelearning.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelearning.db.model.Gym
import com.example.composelearning.network.GymsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymsDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var apiService: GymsApiService
    var state = mutableStateOf<Gym?>(null)

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://gyms-3a73e-default-rtdb.firebaseio.com/")
            .build()
        apiService = retrofit.create(GymsApiService::class.java)
        val gymId = savedStateHandle.get<Int>("gymId") ?: 0
        getGym(gymId)
    }

    fun getGym(id: Int) {
        viewModelScope.launch {
            val gym = getGymFromRemoteDB(id)
            state.value = gym
        }
    }

    private suspend fun getGymFromRemoteDB(id: Int) = withContext(Dispatchers.IO) {
        apiService.getGym(id).values.first()
    }

}