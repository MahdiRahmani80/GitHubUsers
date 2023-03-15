package ir.rahmani.githubproject.userInterface.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.model.User
import ir.rahmani.githubproject.ui.theme.GithubprojectTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavItem(list: List<User>?, onClick: (user: User) -> Unit) {

    GithubprojectTheme {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            if (list != null) {
                items(count = list.size) { index ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
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
                                .padding(20.dp, 16.dp),
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
                                        .clip(CircleShape)
                                        .size(80.dp)
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {


                                Text(
                                    text = list[index].login.toString(),
                                    color = MaterialTheme.colorScheme.tertiary,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(20.dp, 0.dp),
                                )
                                Text(
                                    text = "\uD83D\uDD17 "+list[index].html_url.toString(),
                                    color = MaterialTheme.colorScheme.tertiary,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 9.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(20.dp, 0.dp),
                                )
                                Text(
                                    text = "is system admin: ${list[index].site_admin}",
                                    color = MaterialTheme.colorScheme.tertiary,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 9.sp,
                                    modifier = Modifier.padding(0.dp, 0.dp),
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp,0.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = stringResource(id = R.string.follower),
                                            fontFamily = FontFamily.SansSerif,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.tertiary,
                                        )
                                        Text(
                                            text = "followerCount",
                                            fontFamily = FontFamily.SansSerif,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 9.sp,
                                            color = MaterialTheme.colorScheme.tertiary,
                                        )
                                    }

                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = stringResource(id = R.string.following),
                                            fontFamily = FontFamily.SansSerif,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.tertiary,
                                        )
                                        Text(
                                            text = "followingCount",
                                            fontFamily = FontFamily.SansSerif,
                                            fontSize = 9.sp,
                                            color = MaterialTheme.colorScheme.tertiary,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                    }
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = stringResource(id = R.string.repository),
                                            fontFamily = FontFamily.SansSerif,
                                            fontSize = 11.sp,
                                            color = MaterialTheme.colorScheme.tertiary,
                                        )
                                        Text(
                                            text = "repoCount",
                                            fontFamily = FontFamily.SansSerif,
                                            fontSize = 9.sp,
                                            color = MaterialTheme.colorScheme.tertiary,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }

    }
}
