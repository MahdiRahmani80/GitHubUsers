package ir.rahmani.githubproject.data.repository

import ir.rahmani.githubproject.data.ApiInterface
import ir.rahmani.githubproject.model.SearchResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val api: ApiInterface) {

    suspend fun searchResult(searchUserText: String): Flow<SearchResult> = flow<SearchResult> {
        val response = api.searchUser(searchUserText)
        emit(response)
    }.flowOn(Dispatchers.IO)
}