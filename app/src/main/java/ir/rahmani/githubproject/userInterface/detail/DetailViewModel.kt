package ir.rahmani.githubproject.userInterface.detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.rahmani.githubproject.userInterface.util.UrlName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DetailViewModel : ViewModel() {

    private val LOADING = "loading"
    val repoCount by lazy { MutableLiveData("0") }
    val followerCount by lazy { MutableLiveData("0") }
    val followingCount by lazy { MutableLiveData("0") }


    private fun getRepoSource(sourceUrl: String) {
        val count = (sourceUrl.length - sourceUrl.replace("full_name", "").length) / 9
        Log.i("COUNT_REPO",count.toString())
        if (count != 0) {
            repoCount.postValue(count.toString())
        } else if (sourceUrl == LOADING) {
            repoCount.postValue(LOADING)
        }
    }

    private fun getFollowerSource(sourceUrl: String) {
        val count = (sourceUrl.length - sourceUrl.replace("login", "").length) / 5
        if (count != 0) {
            repoCount.postValue(count.toString())
        } else if (sourceUrl == LOADING) {
            repoCount.postValue(LOADING)
        }
    }

    private fun getFollowingSource(sourceUrl: String) {
        val count = (sourceUrl.length - sourceUrl.replace("login", "").length) / 5
        if (count != 0) {
            repoCount.postValue(count.toString())
        } else if (sourceUrl == LOADING) {
            repoCount.postValue(LOADING)
        }
    }


    fun getUrlSource(url: String, model: UrlName) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val connection = URL(url).openConnection()
                val reader = BufferedReader(InputStreamReader(connection.getInputStream()))
                val sourceCode = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    sourceCode.append(line)
                    sourceCode.append('\n')
                }
                reader.close()
                when (model) {
                    UrlName.FOLLOWER -> {
                        getFollowerSource(sourceCode.toString())
                    }
                    UrlName.FOLLOWING -> {
                        getFollowingSource(sourceCode.toString())
                    }
                    UrlName.REPOSITORY -> {
                        getRepoSource(sourceCode.toString())
                    }
                }

                Log.d("GET_URL_SOURCE", sourceCode.toString())
            } catch (e: IOException) {
                Log.e("GET_URL_SOURCE", e.message.toString())

                when (model) {
                    UrlName.FOLLOWER -> followerCount.postValue(LOADING)
                    UrlName.FOLLOWING -> followingCount.postValue(LOADING)
                    UrlName.REPOSITORY -> followingCount.postValue(LOADING)
                }
            }
        }

    }
}
