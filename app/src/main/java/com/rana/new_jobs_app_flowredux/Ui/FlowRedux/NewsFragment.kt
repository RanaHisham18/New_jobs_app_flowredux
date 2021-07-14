package com.rana.new_jobs_app_flowredux.Ui.FlowRedux

import android.os.Bundle
import android.view.View
import com.rana.new_jobs_app_flowredux.Ui.FlowRedux.NewsActions.Retry

class NewsFragment {
    //view model function is already implemented !!!!!
    val viewModel: NewsViewModel by viewModel()
    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)

        viewModel.dispatch(NewsActions.Retry)


            viewModel.dispatch(Retry)

        }
    override fun renderState(state: NewsState) {
        when(state){
           NewsState.Empty -> {}
            is NewsState.Error -> {}
            NewsState.Loading ->{}
            is NewsState.Success ->{
                state.news
            }
        }
    }

    fun onEffect(effect: Any) {

    }
    }
