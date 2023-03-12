package ir.rahmani.githubproject.userInterface

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.rahmani.githubproject.R

import ir.rahmani.githubproject.ui.theme.GithubprojectTheme

@Composable
fun SplashScreen() {

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
                text = stringResource(id = R.string.app_name) ,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.tertiary,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp)
            )

        }

    }
}