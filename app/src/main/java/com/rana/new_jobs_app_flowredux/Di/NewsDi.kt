package com.rana.new_jobs_app_flowredux.Di

import com.rana.new_jobs_app_flowredux.data.remote.datasource.INewsRemoteDataSource
import com.rana.new_jobs_app_flowredux.data.remote.datasource.NewsRemoteDataSource
import com.rana.new_jobs_app_flowredux.data.remote.service.INewsService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val newsModule = module {
    // view model class name in the ui layer (get())
    viewModel {(get()) }
    single<INewsRemoteDataSource> { NewsRemoteDataSource(get()) }
    single { createNewsService(get()) }
}

fun createNewsService(retrofit: Retrofit) : INewsService{
    return retrofit.create(INewsService::class.java)

}
