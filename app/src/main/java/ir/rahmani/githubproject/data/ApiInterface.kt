package ir.rahmani.githubproject.data

import ir.rahmani.githubproject.model.Repository
import ir.rahmani.githubproject.model.SearchResult
import ir.rahmani.githubproject.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @Headers(
        "Accept: application/vnd.github+json",
        "Authorization: Bearer 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",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    @GET("search/users")
    suspend fun searchUser(@Query("q") searchText: String): SearchResult

    @Headers(
        "Accept: application/vnd.github+json",
        "Authorization: Bearer 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",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    @GET("users/{user}/following")
    suspend fun getFollowing(@Path("user") userLogin:String ): List<User>

    @Headers(
        "Accept: application/vnd.github+json",
        "Authorization: Bearer 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",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    @GET("users/{user}/followers")
    suspend fun getFollower(@Path("user") userLogin:String ): List<User>

    @Headers(
        "Accept: application/vnd.github+json",
        "Authorization: Bearer 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",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    @GET("users/{user}/repos")
    suspend fun getRepositories(@Path("user") userLogin:String ):List<Repository>


    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}