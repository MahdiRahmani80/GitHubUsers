package ir.rahmani.githubproject.userInterface.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.rahmani.githubproject.R


@Composable
fun DetailScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Header()
        Detail()

    }
}


@Composable
fun Header() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .height(60.dp)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                    contentDescription = "back btn",
                    tint = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = "My name is Mahdi",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(15.dp, 3.dp, 0.dp, 0.dp)
                )
            }
        }

        Box {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_24),
                    contentDescription = "fav",
                    tint = Color.Red
                )
                Icon(
                    painter = painterResource(R.drawable.baseline_settings_24),
                    contentDescription = "setting",
                    modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 0.dp),
                    tint = MaterialTheme.colorScheme.tertiary
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_language_24),
                    contentDescription = "language",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        } // end Box

    }
}

@Composable
fun Detail() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(MaterialTheme.colorScheme.primary)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),// todo-> get images in Data
            contentDescription = "use image",
            modifier = Modifier
                .padding(0.dp, 8.dp, 0.dp, 0.dp)
                .clip(CircleShape)
                .size(100.dp)
        )

        Text(
            text = "My name is Mahdi",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 14.sp,
            modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp)
        )
        Text(
            text = "Kotlin Developer",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = 10.sp,
            modifier = Modifier.padding(0.dp, 9.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun DetailScreenTabLayout() {

}