package com.rana.new_jobs_app_flowredux.Ui.FlowRedux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsViewModel(val stateMachine: NewsStatemachine) : ViewModel() {
    init {
        dispatch(NewsActions.Retry)
    }

    fun dispatch(newsAction: NewsActions) {
        viewModelScope.launch {
          //  Timber.tag("FlowRedux - action -> ").d(action.toString())
            stateMachine.dispatch(newsAction)
        }
    }


}