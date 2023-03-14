package ir.rahmani.githubproject.model

data class SearchResult(
    val total_count:Int?,
    val incomplete_results:Boolean?,
    val items:List<User>?
)