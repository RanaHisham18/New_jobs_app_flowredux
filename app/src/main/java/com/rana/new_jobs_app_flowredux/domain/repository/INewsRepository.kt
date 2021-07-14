package com.rana.new_jobs_app_flowredux.domain.repository

import arrow.core.Either
import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse

interface INewsRepository {
    suspend fun fetchNews(): Either<String, List<NewsResponse.Article>>
}