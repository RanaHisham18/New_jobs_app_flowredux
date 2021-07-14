package com.rana.new_jobs_app_flowredux.Ui.FlowRedux

import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse

sealed class NewsState {
    object Loading : NewsState()
    data class Success(
        val news: List<NewsResponse.Article>,
        val isRefreshing: Boolean,
    ) : NewsState()

    data class Error(val message: String) : NewsState()
    object Empty : NewsState()
}

sealed class NewsActions {
    object Fetch : NewsActions()
    object Retry : NewsActions()
    object Refresh : NewsActions()
}