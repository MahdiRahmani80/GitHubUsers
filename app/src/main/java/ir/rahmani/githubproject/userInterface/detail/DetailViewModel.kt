package ir.rahmani.githubproject.userInterface.detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.rahmani.githubproject.data.ApiInterface
import ir.rahmani.githubproject.data.apiState.ApiGetRepository
import ir.rahmani.githubproject.data.apiState.ApiGetUserListState
import ir.rahmani.githubproject.data.apiState.ApiSearchUserState
import ir.rahmani.githubproject.data.repository.Repository
import ir.rahmani.githubproject.model.User
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {

    val repo: MutableState<ApiGetRepository> by lazy {
        mutableStateOf(ApiGetRepository.Empty)
    }
    val follower: MutableState<ApiGetUserListState> by lazy {
        mutableStateOf(ApiGetUserListState.Empty)
    }
    val following: MutableState<ApiGetUserListState> by lazy {
        mutableStateOf(ApiGetUserListState.Empty)
    }
    val isUserAdded = mutableStateOf(false)

    fun addFavUser(user: User) {
        viewModelScope.launch {
            repository.addFavUser(user).catch {
                Log.e("ADD_FAV_USER", it.message.toString())
            }.collect {
                isUserAdded.value = true
                Log.i("ADD_FAV_USER","user successfully added")
            }
        }
    }

    fun getFollower(user: String) {
        viewModelScope.launch {
            repository.getFollowers(user).onStart {
                follower.value = ApiGetUserListState.Loading
                Log.i("GET_FOLLOWING_TEST", "Loading")

            }.catch {
                Log.e("GET_FOLLOWING_TEST", it.message.toString())
                follower.value = ApiGetUserListState.Failure(it)

            }.collect {
                Log.i("GET_FOLLOWING_TEST", it.toString())
                follower.value = ApiGetUserListState.Success(it)
            }
        }
    }

    fun getRepository(user: String) {
        viewModelScope.launch {
            repository.getRepository(user).onStart {
                Log.i("GET_REPO", "loading")
                repo.value = ApiGetRepository.Loading
            }.catch {
                Log.e("GET_REPO", it.message.toString())
                repo.value = ApiGetRepository.Failure(it)
            }.collect {
                Log.i("GET_REPO", it.toString())
                repo.value = ApiGetRepository.Success(it)
            }
        }
    }

    fun getFollowing(user: String) {
        viewModelScope.launch {
            repository.getFollowing(user).onStart {
                Log.i("GET_FOLLOWING", "loading")
                following.value = ApiGetUserListState.Loading
            }.catch {
                Log.e("GET_FOLLOWING", it.toString())
                following.value = ApiGetUserListState.Failure(it)
            }.collect {
                Log.i("GET_FOLLOWING", it.toString())
                following.value = ApiGetUserListState.Success(it)
            }
        }
    }
}
