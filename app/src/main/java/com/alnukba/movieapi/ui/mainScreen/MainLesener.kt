package com.alnukba.movieapi.ui.mainScreen

import com.alnukba.movieapi.models.movieModel.poupolarMovie



interface MainLesener {
    fun OnStart()
    fun OnSuccess(
        popularRes: poupolarMovie,
         topRatedMovie: poupolarMovie,
         upcommingMove: poupolarMovie,
         nowPlayingMovie: poupolarMovie
    )
    fun onFailer(message:String)
    fun onFailerNet(message:String)


}