
package com.rana.new_jobs_app_flowredux.data.remote.entities
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
) {
    @JsonClass(generateAdapter = true)
    data class Article(
        val source: Source,
        val author: Any?,
        val title: String,
        val description: Any?,
        val url: String,
        val urlToImage: Any?,
        val publishedAt: String,
        val content: Any?
    ) {
        @JsonClass(generateAdapter = true)
        data class Source(
            val id: String?,
            val name: String
        )
    }
}