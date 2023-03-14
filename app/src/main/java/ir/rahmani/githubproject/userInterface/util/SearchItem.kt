package ir.rahmani.githubproject.userInterface.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.model.User
import ir.rahmani.githubproject.ui.theme.GithubprojectTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResult(list: List<User>, onClick: (user: User) -> Unit) {

    GithubprojectTheme {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            items(count = list.size) { index ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(20.dp, 8.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    onClick = { onClick(list[index]) },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.linearGradient(
                                    colors =
                                    listOf(
                                        MaterialTheme.colorScheme.tertiary.copy(0.4f),
                                        MaterialTheme.colorScheme.primary.copy(0.2f)
                                    )
                                )
                            )
                            .padding(20.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        if (list[index].avatar_url!!.isNotEmpty()) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    list[index].avatar_url, placeholder = painterResource(
                                        id = R.drawable.ic_launcher_background
                                    )
                                ),
                                contentDescription = "use image",
                                modifier = Modifier
                                    .clip(androidx.compose.foundation.shape.CircleShape)
                                    .size(70.dp)
                            )
                        }
                        Text(
                            text = list[index].login.toString(),
                            color = MaterialTheme.colorScheme.tertiary,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(20.dp, 0.dp),

                            )
                    }
                }

            }
        }

    }
}
