package com.alnukba.movieapi.apiServices



import com.alnukba.movieapi.models.categoryModel.categoryModel
import com.alnukba.movieapi.models.detailsModel.movieDetails
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.mustafayusef.sharay.database.databaseApp

import com.mustafayusef.sharay.database.entitis.favouriteMovieModel
import com.mustafayusef.wakely.utils.SafeApiRequest
import okhttp3.MultipartBody

class Repostary(
    val api: myApi,
    val db: databaseApp
): SafeApiRequest() {

// network
    suspend fun getPoupolarMovie(): poupolarMovie {

        return SafeRequest {
            api.getPopolarMovie()
        }
    }

    suspend fun getTopRatedMovie(): poupolarMovie {
        return SafeRequest {
            api.getTopRated()
        }
    }
    suspend fun getUpcomming(): poupolarMovie {
        return SafeRequest {
            api.getupcoming()
        }
    }
    suspend fun getNowPlaying(): poupolarMovie {
        return SafeRequest {
            api.getNowPlaying()
        }
    }
    suspend fun getSimilarMovie(id:Int): poupolarMovie {
        return SafeRequest {
            api.getSimilarMovie(id)
        }
    }

    suspend fun getMovieDetails(id:Int): movieDetails {
        return SafeRequest {
            api.getMovieDetails(id)
        }
    }
    suspend fun getCategory(): categoryModel {
        return SafeRequest {
            api.getCategory()
        }
    }
    suspend fun getMovieByCategory(id:Int): poupolarMovie {
        return SafeRequest {
            api.getMoviesByGenre(id)
        }
    }
    //database
    suspend fun deleteMovie(id:Int):Int{
        return db.Car_Dao().deleteMovie(id)
    }
    suspend fun insertMovie(movie: favouriteMovieModel): Long {
        return db.Car_Dao().insertMovie(movie)
    }
    suspend fun getAllFavouriteMovie():List<favouriteMovieModel>{
        return db.Car_Dao().getAllFavouriteMovie()
    }
}


