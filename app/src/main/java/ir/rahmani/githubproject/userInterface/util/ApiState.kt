package ir.rahmani.githubproject.userInterface.util

import ir.rahmani.githubproject.model.SearchResult

sealed class ApiState{

    class Success (val data:SearchResult): ApiState()
    class Failure(val msg:Throwable): ApiState()
    object Loading:ApiState()
    object Empty:ApiState()
}
