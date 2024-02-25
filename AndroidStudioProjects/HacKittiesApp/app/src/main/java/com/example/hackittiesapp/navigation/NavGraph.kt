package com.example.hackittiesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.hackittiesapp.screens.DetailScreen
import com.example.hackittiesapp.screens.HomeScreen
import com.example.hackittiesapp.screens.LastScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route  )
    {
            composable(
                route = Screen.HomeScreen.route,
            ){
                HomeScreen(navController)
            }

        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                },
                navArgument("age"){
                    type = NavType.IntType
                }
            )
        ){
            val name = it.arguments?.getString("name", "")?: ""
            val age = it.arguments?.getInt("age", 0)?: 0
            DetailScreen(navController, name, age)
        }

        composable(
            route = Screen.LastScreen.route
        ){
            LastScreen(navController)
        }
    }
}