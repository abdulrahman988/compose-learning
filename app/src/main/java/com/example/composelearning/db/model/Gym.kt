package com.example.composelearning.db.model

import com.google.gson.annotations.SerializedName

data class Gym(
    @SerializedName("id")
    val id: Int,
    @SerializedName("gym_location")
    var gymLocation: String,
    @SerializedName("gym_name")
    var gymName: String,
    @SerializedName("is_open")
    var isOpen: Boolean
)