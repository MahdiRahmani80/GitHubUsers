package ir.rahmani.githubproject.userInterface.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.ui.theme.GithubprojectTheme


@Composable
fun NoDataExist(){

    GithubprojectTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.empty_box),
                contentDescription = "No Data",
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Text(text = stringResource(id = R.string.no_data),
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

        }
    }
}