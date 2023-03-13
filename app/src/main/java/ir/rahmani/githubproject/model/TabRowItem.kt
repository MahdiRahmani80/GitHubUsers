package ir.rahmani.githubproject.model

import androidx.compose.runtime.Composable

data class TabRowItem(
    val title:String,
    val screen:@Composable () -> Unit,
)
