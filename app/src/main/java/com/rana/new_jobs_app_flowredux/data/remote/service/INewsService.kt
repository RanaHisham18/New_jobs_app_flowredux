package com.rana.new_jobs_app_flowredux.data.remote.service

import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse
import retrofit2.http.GET

interface INewsService {
    @GET("top-headlines?country=eg&apiKey=a92d4e159d5a481b957c0074147e96f0")
    suspend fun fetchnews(): NewsResponse
}