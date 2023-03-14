package ir.rahmani.githubproject.userInterface.main

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.Color
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
import ir.rahmani.githubproject.R
import ir.rahmani.githubproject.model.User
import ir.rahmani.githubproject.ui.theme.GithubprojectTheme
import ir.rahmani.githubproject.userInterface.util.ApiState
import ir.rahmani.githubproject.userInterface.util.NoDataExist
import ir.rahmani.githubproject.userInterface.util.SearchResult
import org.koin.androidx.compose.get
import org.koin.androidx.compose.inject


@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(navController: NavController) {

    val searchedText by mutableStateOf("")
    val vm: MainViewModel by inject()

    val dataState:ApiState = vm.response.value

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

                    Header()
                    Spacer(modifier = Modifier.padding(5.dp))

                    SearchBox {text->
                        vm.searchUser(text)
                    }
                }
            }
            // Show Body of MainScreen
            if (dataState !is ApiState.Success) {
                NoDataExist()
            } else {
//                val users=search(searchedText,vm)
                SearchResult(dataState.data.items!!) { id ->
//                     todo onClick item
            }
            }
        }
    }
}

@Composable
fun Header() {
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
fun SearchBox(onClicked: (text: String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(10.dp)
    ) {

        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = { text = it;/*onClicked()*/ },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            leadingIcon = {
                Icon(Icons.Default.Search, "", tint = Color.Gray)
            },

            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {

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

