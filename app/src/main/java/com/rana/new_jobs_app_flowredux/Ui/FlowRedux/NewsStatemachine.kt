package com.rana.new_jobs_app_flowredux.Ui.FlowRedux

import arrow.core.Either
import com.freeletics.flowredux.GetState
import com.freeletics.flowredux.dsl.FlowReduxStateMachine
import com.freeletics.flowredux.dsl.SetState
import com.rana.new_jobs_app_flowredux.domain.repository.INewsRepository

class NewsStatemachine(
    private val repo: INewsRepository,
) : FlowReduxStateMachine<NewsState, NewsActions>(initialState = NewsState.Loading) {


    init {
        spec {
            inState<NewsState.Loading> {
                on(block = ::fetchNews)
            }

            inState<NewsState.Success> {
                on(block = ::refresh)
            }
            inState<NewsState.Empty> {
                on(block = ::refresh)
            }
        }
    }

    private fun <T> inState(function: () -> Unit) {

    }

    suspend fun fetchNews(
        action: NewsActions.Fetch,
        getState: GetState<NewsState>,
        setState: SetState<NewsState>,
    ) {
        when (val result = repo.fetchNews()) {
            is Either.Left -> setState { NewsState.Error("Error Message") }
            is Either.Right -> setState {
                NewsState.Success(
                    news = result.b,
                    isRefreshing = false
                )
            }
        }
    }

    suspend fun refresh(
        action: NewsActions.Refresh,
        getState: GetState<NewsState>,
        setState: SetState<NewsState>,
    ) {
        val currentState = getState()
        if (currentState is NewsState.Success) {
            setState {
                currentState.copy(
                    isRefreshing = true
                )
            }
            when (val result = repo.fetchNews()) {
                is Either.Left -> {
                    setState {
                        currentState.copy(
                            isRefreshing = false
                        )
                    }
                }
                is Either.Right -> {
                    setState {
                        currentState.copy(
                            isRefreshing = false,
                            news = result.b
                        )
                    }
                }
            }
        }
    }
}
