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

class GymsViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var state by mutableStateOf(emptyList<Gym>())
    private var apiService: GymsApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://gyms-3a73e-default-rtdb.firebaseio.com/")
            .build()
        apiService = retrofit.create(GymsApiService::class.java)
        getGyms()
    }
    private fun getGyms(){
        viewModelScope.launch {
            val gyms = getGymsFromRemoteDB()
            state = gyms.restoreSelectedGyms()
        }
    }

    private suspend fun getGymsFromRemoteDB() =  withContext(Dispatchers.IO){
        apiService.getGyms()
    }

    fun toggleFavouriteState(gymId: Int){
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isOpen = !gyms[itemIndex].isOpen)
        storeSelectedGym(gyms[itemIndex])
        state = gyms
    }

    private fun storeSelectedGym(gym: Gym) {
        val savedHandleList = savedStateHandle.get<List<Int>?>("savesIds").orEmpty().toMutableList()
        if (gym.isOpen)savedHandleList.add(gym.id)
        else savedHandleList.remove(gym.id)
        savedStateHandle["savesIds"] = savedHandleList
    }

    private fun List<Gym>.restoreSelectedGyms(): List<Gym> {
        val gyms = this
        savedStateHandle.get<List<Int>?>("savesIds").let { savedIds ->
            savedIds?.forEach {  gymId ->
                gyms.find { it.id == gymId}?.isOpen = true
            }
        }
        return gyms
    }
}