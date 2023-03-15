package ir.rahmani.githubproject.data.repository

import ir.rahmani.githubproject.data.ApiInterface
import ir.rahmani.githubproject.data.local.Dao
import ir.rahmani.githubproject.data.local.DataBase
import ir.rahmani.githubproject.model.SearchResult
import ir.rahmani.githubproject.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val api: ApiInterface, private val dao: Dao) {

    suspend fun searchResult(searchUserText: String): Flow<SearchResult> = flow<SearchResult> {
        val response = api.searchUser(searchUserText)
        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun getFollowers(userName: String): Flow<List<User>> = flow {
        val response = api.getFollower(userName)
        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun getFollowing(userLogin: String): Flow<List<User>> = flow {
        val response = api.getFollowing(userLogin = userLogin)
        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun getRepository(userName: String): Flow<List<ir.rahmani.githubproject.model.Repository>> =
        flow {
            val response = api.getRepositories(userName)
            emit(response)
        }.flowOn(Dispatchers.IO)


    suspend fun addFavUser(user: User): Flow<Boolean> = flow {
        dao.addFavUser(user)
        emit(true)
    }.flowOn(Dispatchers.IO)

    suspend fun delFavUser(user: User): Flow<Boolean> = flow {
        dao.delFavUser(user)
        emit(true)
    }.flowOn(Dispatchers.IO)

    suspend fun getAllFav(): Flow<List<User>> = flow {
        val response =dao.getAllFav()
        emit(response)
    }.flowOn(Dispatchers.IO)

    suspend fun isExistInFav(id:Int):Flow<Boolean> = flow {
        val bool = dao.isInFavUserExist(id)
        emit(bool)
    }.flowOn(Dispatchers.IO)
}