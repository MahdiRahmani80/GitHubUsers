package ir.rahmani.githubproject.userInterface.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.rahmani.githubproject.data.repository.Repository
import ir.rahmani.githubproject.data.apiState.ApiSearchUserState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val repo: Repository) : ViewModel() {


    // Search User
    val response: MutableState<ApiSearchUserState> by lazy {
        mutableStateOf(ApiSearchUserState.Empty)
    }

    fun searchUser(searchText: String) {
        viewModelScope.launch {
            repo.searchResult(searchText).onStart {
                response.value = ApiSearchUserState.Loading
                Log.i("API_TEST", "Loading")

            }.catch {
                response.value = ApiSearchUserState.Failure(it)
                Log.e("API_TEST", "Failure")

            }.collect {
                response.value = ApiSearchUserState.Success(it)
                Log.i("API_TEST", "Success")
            }
        }
    }


}


