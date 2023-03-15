package ir.rahmani.githubproject.userInterface.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.nav.Screen
import ir.rahmani.githubproject.nav.SharedViewModel
import ir.rahmani.githubproject.ui.theme.GithubprojectTheme
import ir.rahmani.githubproject.data.apiState.ApiSearchUserState
import ir.rahmani.githubproject.userInterface.util.NoDataExist
import ir.rahmani.githubproject.userInterface.util.SearchResult
import org.koin.androidx.compose.inject


@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(navController: NavController, sharedViewModel: SharedViewModel) {

    val vm: MainViewModel by inject()

    val dataState: ApiSearchUserState = vm.response.value

    GithubprojectTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.16f)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(15.dp)
            ) {

                Column {

                    Header(navController,sharedViewModel)
                    Spacer(modifier = Modifier.padding(5.dp))

                    SearchBox { text ->
                        vm.searchUser(text)
                    }
                }
            }
            // Show Body of MainScreen
            if (dataState !is ApiSearchUserState.Success) {
                NoDataExist()
            } else {
//                val users=search(searchedText,vm)
                SearchResult(dataState.data.items!!) { user ->
                    sharedViewModel.user.clear()
                    sharedViewModel.addUser(user)
                    navController.navigate(Screen.DetailScreen.route)
                }
            }
        }
    }
}

@Composable
fun Header(navController: NavController,sharedViewModel: SharedViewModel) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontSize = 15.sp,
        )

        Box {
            Row {
                IconButton(
                    onClick = {
                        sharedViewModel.user.clear()
                        navController.navigate(Screen.FavScreen.route)
                    }, modifier = Modifier.size(23.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_favorite_24),
                        contentDescription = "fav",
                        tint = Color.Red
                    )
                }

                Icon(
                    painter = painterResource(R.drawable.baseline_settings_24),
                    contentDescription = "setting",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp,)
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBox(onClicked: (text: String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp)
    ) {

        var text by remember { mutableStateOf(TextFieldValue("")) }
        val keyboardController = LocalSoftwareKeyboardController.current

        TextField(
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = { text = it; },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            leadingIcon = {
                Icon(Icons.Default.Search, "", tint = Color.Gray)
            },
            trailingIcon = {
                if (text.text.isNotEmpty()) {
                    IconButton(onClick = {
                        text = TextFieldValue("")
                        keyboardController?.show()
                    }) {
                        Icon(Icons.Default.Close, "", tint = Color.Gray)
                    }
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
                onClicked(text.text)
            }),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_txt),
                    color = Color.Gray
                )
            },
            maxLines = 1,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
        )

    }
}

