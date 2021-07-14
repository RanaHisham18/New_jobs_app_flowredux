package com.rana.new_jobs_app_flowredux.domain.entities

import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse
import com.squareup.moshi.JsonClass

data class NewsDomain(
    val author: Any?,
    val title: String,
    val description: Any?,
    val url: String,
    val urlToImage: Any?,
    val publishedAt: String,
    val content: Any?,
)
