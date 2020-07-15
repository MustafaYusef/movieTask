package com.alnukba.movieapi.ui.detailsMovie

import androidx.lifecycle.ViewModel;
import com.alnukba.movieapi.apiServices.Repostary
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.alnukba.movieapi.ui.mainScreen.MainLesener
import com.mustafayusef.holidaymaster.utils.ApiExaptions
import com.mustafayusef.holidaymaster.utils.noInternetExeption

import com.mustafayusef.sharay.database.entitis.favouriteMovieModel

import com.mustafayusef.wakely.utils.corurtins
import java.net.ConnectException
import java.net.ProtocolException
import java.net.SocketException
import java.net.SocketTimeoutException

class movieDetailsViewModel(val repostary: Repostary) : ViewModel() {

    var Auth: MovieDetailsLesener?=null


    fun GetMovieDetails(id:Int){
        Auth?.OnStart()

        corurtins.main {
            try {
                var  movieDetailsResponse=repostary.getMovieDetails(id)
                movieDetailsResponse ?.let {

                    Auth?.OnSuccess(movieDetailsResponse!!)
                }

            }catch (e: ApiExaptions){
                e.message?.let { Auth?.onFailer(it) }

            }catch (e: noInternetExeption){
                e.message?.let { Auth?.onFailerNet(it) }
            } catch (e: SocketTimeoutException){
                e.message?.let { Auth?.onFailerNet(it) }
            } catch (e: SocketException){
                e.message?.let { Auth?.onFailerNet(it) }
            }catch (e: ProtocolException){
                e.message?.let { Auth?.onFailerNet(it) }
            }catch (e: ConnectException){
                e.message?.let { Auth?.onFailerNet(it) }
            }

        }

    }
    fun insertMovie(data:favouriteMovieModel) {

        corurtins.main {
            try {
                val NumbersResponse = repostary.insertMovie(data)
                NumbersResponse?.let {
                    Auth?.onSusessInsertMovie(it)
                }

            } catch (e: ApiExaptions) {
                e.message?.let { Auth?.onFailer(it) }

            }
        }
    }


    fun DeleteMovie(id:Int) {

        corurtins.main {
            try {
                val NumbersResponse = repostary.deleteMovie(id)
                NumbersResponse?.let {
                    Auth?.onSusessDeleteMovie(it)
                }

            } catch (e: ApiExaptions) {
                e.message?.let { Auth?.onFailer(it) }

            }
        }
    }



}
