package com.mustafayusef.sharay.database.entitis

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class favouriteMovieModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var backdrop_path: String,

    var genres:String,




    var overview: String,




    var runtime: Double,

    var title: String,

    var vote_average: Double
)