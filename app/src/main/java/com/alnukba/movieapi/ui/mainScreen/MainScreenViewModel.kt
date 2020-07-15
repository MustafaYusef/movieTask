package com.mustafayusef.wakely.ui.main

import androidx.lifecycle.ViewModel;
import com.alnukba.movieapi.apiServices.Repostary
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.alnukba.movieapi.ui.mainScreen.MainLesener
import com.mustafayusef.holidaymaster.utils.ApiExaptions
import com.mustafayusef.holidaymaster.utils.noInternetExeption

import com.mustafayusef.wakely.utils.corurtins
import java.net.ConnectException
import java.net.ProtocolException
import java.net.SocketException
import java.net.SocketTimeoutException

class MainScreenViewModel(val repostary: Repostary) : ViewModel() {

    var Auth: MainLesener?=null


    fun GetMain(){
        var popularRes: poupolarMovie?=null
        var topRatedMovie: poupolarMovie?=null
        var upcommingMove: poupolarMovie?=null
        var nowPlayingMovie: poupolarMovie?=null
        Auth?.OnStart()


        corurtins.main {
            try {
                popularRes=repostary.getPoupolarMovie()
                popularRes ?.let {

                    popularRes=it!!
                    //  Auth?.onComplete()
                }
                topRatedMovie=repostary.getTopRatedMovie()
                topRatedMovie ?.let {
                    topRatedMovie=it!!
                    //  Auth?.onSucsessBanners(it!!)
                }
                upcommingMove=repostary.getUpcomming()
                upcommingMove ?.let {
                    upcommingMove=it!!
                    //  Auth?.onSucsessBanners(it!!)
                }
                nowPlayingMovie=repostary.getNowPlaying()
                nowPlayingMovie ?.let {
                    nowPlayingMovie=it!!
                    //  Auth?.onSucsessBanners(it!!)
                }
                Auth?.OnSuccess(popularRes!!,topRatedMovie!!,upcommingMove!!,nowPlayingMovie!!)

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
            }catch (e:ConnectException){
                e.message?.let { Auth?.onFailerNet(it) }
            }

        }

    }






}
