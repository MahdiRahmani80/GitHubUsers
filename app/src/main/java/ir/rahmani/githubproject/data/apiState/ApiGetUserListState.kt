package ir.rahmani.githubproject.data.apiState

import ir.rahmani.githubproject.model.User

sealed class ApiGetUserListState{

    class Success (val data: List<User>): ApiGetUserListState()
    class Failure(val msg:Throwable): ApiGetUserListState()
    object Loading: ApiGetUserListState()
    object Empty: ApiGetUserListState()
}
