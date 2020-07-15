package com.alnukba.movieapi.ui.detailsMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alnukba.movieapi.apiServices.Repostary


class movieDetailsViewModelFactory(val repostary: Repostary) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return movieDetailsViewModel(repostary) as T
    }
}