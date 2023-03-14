package ir.rahmani.githubproject.data

import ir.rahmani.githubproject.model.SearchResult
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