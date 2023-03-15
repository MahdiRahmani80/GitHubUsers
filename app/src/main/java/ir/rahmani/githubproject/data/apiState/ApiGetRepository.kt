package ir.rahmani.githubproject.data.apiState

import ir.rahmani.githubproject.model.Repository

sealed class ApiGetRepository{
    class Success (val data:List<Repository>): ApiGetRepository()
    class Failure(val msg:Throwable): ApiGetRepository()
    object Loading: ApiGetRepository()
    object Empty: ApiGetRepository()
}
