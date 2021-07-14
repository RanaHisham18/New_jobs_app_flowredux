package com.rana.new_jobs_app_flowredux.Ui.FlowRedux

import com.rana.new_jobs_app_flowredux.domain.entities.NewsDomain

sealed class NewsState {
    object Loading : NewsState()
    data class Success(
        val news: List<NewsDomain>,
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