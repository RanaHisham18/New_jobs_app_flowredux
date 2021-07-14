package com.rana.new_jobs_app_flowredux.Ui.FlowRedux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

class NewsViewModel : ViewModel() {
    init {
        dispatch(NewsActions.Fetch)
    }

    fun dispatch(fetch: NewsActions.Retry) {
        viewModelScope.launch {
            Timber.tag("FlowRedux - action -> ").d(action.toString())
            stateMachine.dispatch(action)
        }
    }

    //actions and states have to be declared in state machine base class or implemented in statemachine fragment.
    override fun onCleared() {

        stateMachine.clear(state.value)
        super.onCleared()
    }

}