package com.mustafayusef.wakely.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alnukba.movieapi.apiServices.Repostary


class FavouriteViewModelFactory(val repostary: Repostary) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavouriteViewModel(repostary) as T
    }
}