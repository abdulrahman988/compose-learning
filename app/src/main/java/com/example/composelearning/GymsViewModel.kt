package com.example.composelearning

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class GymsViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var state = mutableStateOf(restoreSelectedGyms())
    private fun getGyms() = gymList

    fun toggleFavouriteState(gymId: Int){
        val gyms = state.value.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isFavourite = !gyms[itemIndex].isFavourite)
        storeSelectedGym(gyms[itemIndex])
        state.value = gyms
    }

    private fun storeSelectedGym(gym: Gym) {
        val savedHandleList = savedStateHandle.get<List<Int>?>("savesIds").orEmpty().toMutableList()
        if (gym.isFavourite)savedHandleList.add(gym.id)
        else savedHandleList.remove(gym.id)
        savedStateHandle["savesIds"] = savedHandleList
    }

    private fun restoreSelectedGyms(): List<Gym> {
        val gyms = getGyms()
        savedStateHandle.get<List<Int>?>("savesIds").let { savedIds ->
            savedIds?.forEach {  gymId ->
                gyms.find { it.id == gymId}?.isFavourite = true
            }
        }
        return gyms
    }
}