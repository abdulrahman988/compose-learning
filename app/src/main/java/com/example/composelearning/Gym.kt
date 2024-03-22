package com.example.composelearning

val gymList = listOf<Gym>(
    Gym(1, "Gym 1", "Description of Gym 1"),
    Gym(2, "Gym 2", "Description of Gym 2"),
    Gym(3, "Gym 3", "Description of Gym 3"),
    Gym(4, "Gym 4", "Description of Gym 4"),
    Gym(5, "Gym 5", "Description of Gym 5"),
    Gym(6, "Gym 6", "Description of Gym 6"),
    Gym(7, "Gym 7", "Description of Gym 7"),
    Gym(8, "Gym 8", "Description of Gym 8"),
    Gym(9, "Gym 9", "Description of Gym 9"),
    Gym(10, "Gym 10", "Description of Gym 10"),
    Gym(11, "Gym 11", "Description of Gym 11"),
    Gym(12, "Gym 12", "Description of Gym 12"),
    Gym(13, "Gym 13", "Description of Gym 13"),
    Gym(14, "Gym 14", "Description of Gym 14"),
    Gym(15, "Gym 15", "Description of Gym 15"),
    Gym(16, "Gym 16", "Description of Gym 16"),
    Gym(17, "Gym 17", "Description of Gym 17"),
    Gym(18, "Gym 18", "Description of Gym 18"),
    Gym(19, "Gym 19", "Description of Gym 19"),
    Gym(20, "Gym 20", "Description of Gym 20")
)

data class Gym(
    val id: Int,
    var name: String,
    var description: String
)