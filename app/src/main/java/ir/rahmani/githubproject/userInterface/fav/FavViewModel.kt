package ir.rahmani.githubproject.userInterface.fav

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.rahmani.githubproject.data.repository.Repository
import ir.rahmani.githubproject.model.User
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavViewModel(private val repository: Repository) : ViewModel() {


    val favUsers: MutableState<List<User>?> by lazy {
        mutableStateOf(null)
    }

    fun getAllFavUsers() {
        viewModelScope.launch {
            repository.getAllFav().catch {
                Log.e("GET_ALL_USER_LOCAL", it.message.toString())
            }.collect {
                favUsers.value = it
                Log.i("GET_ALL_USER_LOCAL", "get data was successfully ")
            }
        }
    }
}