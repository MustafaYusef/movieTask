package com.alnukba.movieapi.ui.category

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

class CategoryViewModel(val repostary: Repostary) : ViewModel() {

    var Auth: CategoryLesener?=null


    fun GetGenres(){
        Auth?.OnStart()

        corurtins.main {
            try {
                var  categoryResponse=repostary.getCategory()
                categoryResponse ?.let {

                    Auth?.OnSuccessGetGenres(categoryResponse!!)
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
    fun GetMoviesByGenres(id:Int){
        Auth?.OnStart()

        corurtins.main {
            try {
                var  categoryResponse=repostary.getMovieByCategory(id)
                categoryResponse ?.let {

                    Auth?.OnSuccessGetMovies(categoryResponse!!)
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



}
