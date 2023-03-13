package ir.rahmani.githubproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.rahmani.githubproject.nav.Screen
import ir.rahmani.githubproject.userInterface.SplashScreen
import ir.rahmani.githubproject.userInterface.main.MainScreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route ){

        composable(route = Screen.Splash.route){
            SplashScreen(navController)
        }
        composable(route = Screen.MainScreen.route){
            MainScreen()
        }
    }
}