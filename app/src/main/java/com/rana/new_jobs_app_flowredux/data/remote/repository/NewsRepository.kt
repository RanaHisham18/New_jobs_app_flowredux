package com.rana.new_jobs_app_flowredux.data.remote.repository

import arrow.core.Either
import com.rana.new_jobs_app_flowredux.data.remote.datasource.INewsRemoteDataSource
import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse
import com.rana.new_jobs_app_flowredux.domain.repository.INewsRepository

class NewsRepository (
    private val remote : INewsRemoteDataSource): INewsRepository{
        override suspend fun fetchNews (): Either<String, List<NewsResponse.Article>> {
            return remote.fetchNews()
        }
}


