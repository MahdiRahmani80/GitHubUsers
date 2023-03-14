package ir.rahmani.githubproject.userInterface.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.rahmani.githubproject.data.repository.Repository
import ir.rahmani.githubproject.model.SearchResult
import ir.rahmani.githubproject.userInterface.util.ApiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(private val repo: Repository) : ViewModel() {


    // Search User
    val response: MutableState<ApiState> by lazy {
        mutableStateOf(ApiState.Empty)
    }

    fun searchUser(searchText: String) {
        viewModelScope.launch {
            repo.searchResult(searchText).onStart {
                response.value = ApiState.Loading
                Log.i("API_TEST", "Loading")

            }.catch {
                response.value = ApiState.Failure(it)
                Log.i("API_TEST", "Failure")

            }.collect {
                response.value = ApiState.Success(it)
                Log.i("API_TEST", "Success")
            }
        }
    }


}


