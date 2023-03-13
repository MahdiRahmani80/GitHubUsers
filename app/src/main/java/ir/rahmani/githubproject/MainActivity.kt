package ir.rahmani.githubproject

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import ir.rahmani.githubproject.ui.theme.GithubprojectTheme
import ir.rahmani.githubproject.userInterface.SplashScreen
import ir.rahmani.githubproject.userInterface.detail.DetailScreen
import ir.rahmani.githubproject.userInterface.main.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            GithubprojectTheme {
                Navigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubprojectTheme {
    }
}