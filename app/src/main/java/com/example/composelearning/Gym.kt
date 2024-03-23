package com.example.composelearning

val gymList = listOf<Gym>(
    Gym(1, "Gym 1", "Place of Gym 1"),
    Gym(2, "Gym 2", "Place of Gym 2"),
    Gym(3, "Gym 3", "Place of Gym 3"),
    Gym(4, "Gym 4", "Place of Gym 4"),
    Gym(5, "Gym 5", "Place of Gym 5"),
    Gym(6, "Gym 6", "Place of Gym 6"),
    Gym(7, "Gym 7", "Place of Gym 7"),
    Gym(8, "Gym 8", "Place of Gym 8"),
    Gym(9, "Gym 9", "Place of Gym 9"),
    Gym(10, "Gym 10", "Place of Gym 10"),
    Gym(11, "Gym 11", "Place of Gym 11"),
    Gym(12, "Gym 12", "Place of Gym 12"),
    Gym(13, "Gym 13", "Place of Gym 13"),
    Gym(14, "Gym 14", "Place of Gym 14"),
    Gym(15, "Gym 15", "Place of Gym 15"),
    Gym(16, "Gym 16", "Place of Gym 16"),
    Gym(17, "Gym 17", "Place of Gym 17"),
    Gym(18, "Gym 18", "Place of Gym 18"),
    Gym(19, "Gym 19", "Place of Gym 19"),
    Gym(20, "Gym 20", "Place of Gym 20")
)

data class Gym(
    val id: Int,
    var name: String,
    var place: String,
    var isFavourite: Boolean = false
)