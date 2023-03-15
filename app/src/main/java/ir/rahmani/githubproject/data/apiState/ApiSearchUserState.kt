package ir.rahmani.githubproject.data.apiState

import ir.rahmani.githubproject.model.SearchResult

sealed class ApiSearchUserState{

    class Success (val data:SearchResult): ApiSearchUserState()
    class Failure(val msg:Throwable): ApiSearchUserState()
    object Loading: ApiSearchUserState()
    object Empty: ApiSearchUserState()
}
