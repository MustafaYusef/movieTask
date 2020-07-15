package com.alnukba.movieapi.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alnukba.movieapi.apiServices.Repostary


class CategoryViewModelFactory(val repostary: Repostary) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryViewModel(repostary) as T
    }
}