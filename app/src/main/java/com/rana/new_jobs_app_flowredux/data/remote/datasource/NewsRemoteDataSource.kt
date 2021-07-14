package com.rana.new_jobs_app_flowredux.data.remote.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse
import com.rana.new_jobs_app_flowredux.data.remote.service.INewsService
import com.rana.new_jobs_app_flowredux.domain.safe

class NewsRemoteDataSource(
    private val service: INewsService,
) : INewsRemoteDataSource {


    override suspend fun fetchNews(): Either<String, List<NewsResponse.Article>> = safe {

        val response = service.fetchnews()
        if (response.status == "ok") {
            response.articles.right()

        } else {
            "".left()
        }

    }


}