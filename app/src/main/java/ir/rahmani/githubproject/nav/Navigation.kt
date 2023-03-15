package ir.rahmani.githubproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.rahmani.githubproject.nav.Screen
import ir.rahmani.githubproject.nav.SharedViewModel
import ir.rahmani.githubproject.userInterface.SplashScreen
import ir.rahmani.githubproject.userInterface.detail.DetailScreen
import ir.rahmani.githubproject.userInterface.fav.Favorite
import ir.rahmani.githubproject.userInterface.main.MainScreen
import org.koin.androidx.compose.inject

@Composable
fun Navigation() {

    val viewModel: SharedViewModel by inject()
    var counter = 0

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController, viewModel)
        }
        composable(route = Screen.DetailScreen.route) {
            DetailScreen(navController, viewModel)
        }
        composable(route= Screen.FavScreen.route){
            Favorite(navController = navController)
        }
    }
}