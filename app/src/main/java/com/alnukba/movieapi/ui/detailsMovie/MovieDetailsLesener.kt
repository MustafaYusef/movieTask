package com.alnukba.movieapi.ui.detailsMovie

import com.alnukba.movieapi.models.detailsModel.movieDetails
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.mustafayusef.holidaymaster.utils.ApiExaptions
import com.mustafayusef.holidaymaster.utils.noInternetExeption
import com.mustafayusef.wakely.utils.corurtins
import java.net.ConnectException
import java.net.ProtocolException
import java.net.SocketException
import java.net.SocketTimeoutException


interface MovieDetailsLesener {
    fun OnStart()
    fun OnSuccess(
        details: movieDetails

    )
    fun onFailer(message:String)
    fun onFailerNet(message:String)
     fun onSusessInsertMovie(it: Long)
     fun onSusessDeleteMovie(it: Int)


}