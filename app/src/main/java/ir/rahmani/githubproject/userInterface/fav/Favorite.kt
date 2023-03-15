package ir.rahmani.githubproject.userInterface.fav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.userInterface.util.SearchResult

@Composable
fun Favorite(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize()) {

        Header()
        SearchResult(list = null) {

        }
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
                IconButton(onClick = {
                    // todo -> back track
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
                        contentDescription = "back btn",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
                Text(
                    text = stringResource(id = R.string.fav),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(15.dp, 3.dp, 0.dp, 0.dp)
                )
            }
        }


        Row {
            Icon(
                painter = painterResource(R.drawable.baseline_settings_24),
                contentDescription = "setting",
                modifier = Modifier.padding(13.dp, 0.dp, 13.dp, 0.dp),
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}