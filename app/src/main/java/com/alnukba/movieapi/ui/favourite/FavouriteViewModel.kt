package com.mustafayusef.wakely.ui.main

import androidx.lifecycle.ViewModel;
import com.alnukba.movieapi.apiServices.Repostary
import com.alnukba.movieapi.ui.favourite.FavouriteLesener
import com.mustafayusef.holidaymaster.utils.ApiExaptions
import com.mustafayusef.sharay.database.entitis.favouriteMovieModel
import com.mustafayusef.wakely.utils.corurtins

class FavouriteViewModel(val repostary: Repostary) : ViewModel() {

    var Auth: FavouriteLesener?=null

    fun getAllFavouriteMovie() {
     Auth?.OnStart()
        corurtins.main {
            try {
                val NumbersResponse = repostary.getAllFavouriteMovie()
                NumbersResponse?.let {
                    Auth?.OnSuccess(it)
                }

            } catch (e: ApiExaptions) {
                e.message?.let { Auth?.onFailer(it) }

            }
        }
    }




}
