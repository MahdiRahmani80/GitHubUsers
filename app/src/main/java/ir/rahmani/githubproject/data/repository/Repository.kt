package ir.rahmani.githubproject.data.repository

import ir.rahmani.githubproject.data.ApiInterface
import ir.rahmani.githubproject.model.SearchResult
import ir.rahmani.githubproject.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val api: ApiInterface) {

    suspend fun searchResult(searchUserText: String): Flow<SearchResult> = flow<SearchResult> {
        val response = api.searchUser(searchUserText)
        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun getFollowers(userName:String):Flow<List<User>> = flow {
        val response= api.getFollower(userName)
        emit(response)
    }.flowOn(Dispatchers.IO)
}