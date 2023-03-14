package ir.rahmani.githubproject.nav

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ir.rahmani.githubproject.model.User

class SharedViewModel : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    fun addUser(user: User){
        this.user=user
    }
}