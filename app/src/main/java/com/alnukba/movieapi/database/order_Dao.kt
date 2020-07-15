package com.mustafayusef.sharay.database

import androidx.room.*

import com.mustafayusef.sharay.database.entitis.favouriteMovieModel


@Dao
interface order_Dao {
    //Category
    @Query("select * from favouriteMovieModel")
    suspend fun getAllFavouriteMovie():List<favouriteMovieModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertMovie(movies: favouriteMovieModel):Long



      @Query("delete from favouriteMovieModel where id=:id")
    suspend fun deleteMovie(id: Int?):Int

}