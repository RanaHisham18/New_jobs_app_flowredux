package com.rana.new_jobs_app_flowredux.data.remote.datasource

import arrow.core.Either
import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse.Article

interface INewsRemoteDataSource {
    suspend fun fetchNews(): Either<String, List<Article>>
}