package ir.rahmani.githubproject.userInterface.detail

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.model.TabRowItem
import ir.rahmani.githubproject.userInterface.util.SearchResult
import kotlinx.coroutines.launch


@Composable
fun DetailScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Header()
        Detail()
        DetailScreenTabLayout()

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
                    text = "Mahdi Rahmani",
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
            .fillMaxHeight(0.400f)
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .height(85.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = R.string.follower),
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Text(
                        text = "29",
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = R.string.following),
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Text(
                        text = "23",
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = R.string.repository),
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Text(
                        text = "5",
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
        }


    }
}

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("RememberReturnType")
@Composable
fun DetailScreenTabLayout() {

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val tabRowItems = listOf(
        TabRowItem(
            title = stringResource(id = R.string.follower),
            screen = { TabScreen(text = stringResource(id = R.string.follower)) }
        ),
        TabRowItem(
            title = stringResource(id = R.string.following),
            screen = { TabScreen(text = stringResource(id = R.string.following)) }
        ),
    )

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        indicator = { tabPositions: List<TabPosition> ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                color = Color.Transparent,
            )
        }
    ) {

        tabRowItems.forEachIndexed { index, item ->
            val selected = pagerState.currentPage == index
            Tab(
                selected = selected,
                onClick = {
                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                },
                text = {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                    )
                    if (!selected) {
                        Text(
                            text = item.title,
                            maxLines = 1,
                            color = MaterialTheme.colorScheme.tertiary,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                },
                modifier = if (selected) Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .clip(RoundedCornerShape(30, 30, 0, 0))
                    .background(Color.White)

                else Modifier
                    .background(color = MaterialTheme.colorScheme.primary)
                    .clip(RoundedCornerShape(30, 30, 0, 0))
                    .background(color = MaterialTheme.colorScheme.primary)
            )
        }
    }

    HorizontalPager(
        count = tabRowItems.size,
        state = pagerState,
    ) {
        tabRowItems[pagerState.currentPage].screen()
    }

}

@Composable
fun TabScreen(text: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SearchResult(
            list = arrayListOf(
                "Ali",
                "Mahdi",
                "Reza",
                "Mohammad Reza",
                "A",
                "B",
                "Mohammad Reza",
                "A",
                "B"
            ),
        ) {
//                 get list id
//                 todo -> go to the detail page
        }
    }
}