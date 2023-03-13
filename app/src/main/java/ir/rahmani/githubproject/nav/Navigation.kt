package ir.rahmani.githubproject

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.rahmani.githubproject.nav.Screen
import ir.rahmani.githubproject.userInterface.SplashScreen
import ir.rahmani.githubproject.userInterface.main.MainScreen

@Composable
fun Navigation() {

    var visible by remember { mutableStateOf(true) }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
    }
}