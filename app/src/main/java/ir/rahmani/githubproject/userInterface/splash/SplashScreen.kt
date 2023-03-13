package ir.rahmani.githubproject.userInterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.nav.Screen

import ir.rahmani.githubproject.ui.theme.GithubprojectTheme
import ir.rahmani.githubproject.userInterface.splash.SplashViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.inject

@Composable
fun SplashScreen(navController: NavController) {

    val vm: SplashViewModel by inject()
    goToMainScreen(vm, navController)

    GithubprojectTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(0.dp, 110.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Icon(
                painter = painterResource(id = R.drawable.ic_github),
                contentDescription = "splash logo",
                tint = MaterialTheme.colorScheme.secondary
            )


            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
            )

        }

    }
}


@Composable
fun goToMainScreen(vm: SplashViewModel, navController: NavController) {
    val bool = vm.delaySplashScreen().collectAsState(initial = false)
    if (bool.value ) {
        navController.navigate(Screen.MainScreen.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }
}