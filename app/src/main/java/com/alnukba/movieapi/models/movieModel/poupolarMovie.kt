package com.alnukba.movieapi.models.movieModel

data class poupolarMovie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)