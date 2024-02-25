package com.example.hackittiesapp.navigation


const val  HomeScreenPath = "HomeScreen"
const val DetailScreenPath = "DetailScreen"
const val  LastScreenPath = "LastDetailScreen"

sealed class Screen (val route: String) {

    object HomeScreen : Screen (HomeScreenPath)
    object DetailScreen: Screen ("$DetailScreenPath/{name}/{age}")
    object LastScreen: Screen (LastScreenPath)
}