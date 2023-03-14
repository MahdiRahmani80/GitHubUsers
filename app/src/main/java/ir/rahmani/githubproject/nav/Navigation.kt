package ir.rahmani.githubproject

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.rahmani.githubproject.model.User
import ir.rahmani.githubproject.nav.Screen
import ir.rahmani.githubproject.nav.SharedViewModel
import ir.rahmani.githubproject.userInterface.SplashScreen
import ir.rahmani.githubproject.userInterface.detail.DetailScreen
import ir.rahmani.githubproject.userInterface.main.MainScreen
import org.koin.androidx.compose.inject

@Composable
fun Navigation() {

    val viewModel:SharedViewModel by inject()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            route = Screen.DetailScreen.route,
        ) {
            DetailScreen(navController, viewModel.user)
        }
    }
}