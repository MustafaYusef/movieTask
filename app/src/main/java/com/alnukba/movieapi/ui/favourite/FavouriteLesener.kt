package com.alnukba.movieapi.ui.favourite

import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.mustafayusef.sharay.database.entitis.favouriteMovieModel


interface FavouriteLesener {
    fun OnStart()
    fun OnSuccess(
        FavoutiteRes: List<favouriteMovieModel>

    )
    fun onFailer(message:String)




}