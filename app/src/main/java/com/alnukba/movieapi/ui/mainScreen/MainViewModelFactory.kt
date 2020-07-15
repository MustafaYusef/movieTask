package com.mustafayusef.wakely.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alnukba.movieapi.apiServices.Repostary


class MainViewModelFactory(val repostary: Repostary) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainScreenViewModel(repostary) as T
    }
}