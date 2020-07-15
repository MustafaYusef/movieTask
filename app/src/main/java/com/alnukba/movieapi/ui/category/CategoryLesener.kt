package com.alnukba.movieapi.ui.category

import com.alnukba.movieapi.models.categoryModel.categoryModel
import com.alnukba.movieapi.models.detailsModel.movieDetails
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.mustafayusef.holidaymaster.utils.ApiExaptions
import com.mustafayusef.holidaymaster.utils.noInternetExeption
import com.mustafayusef.wakely.utils.corurtins
import java.net.ConnectException
import java.net.ProtocolException
import java.net.SocketException
import java.net.SocketTimeoutException


interface CategoryLesener {
    fun OnStart()
    fun OnSuccessGetMovies(
        details: poupolarMovie

    )
    fun OnSuccessGetGenres(
        details: categoryModel

    )
    fun onFailer(message:String)
    fun onFailerNet(message:String)



}