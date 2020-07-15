package com.alnukba.movieapi.ui.detailsMovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.alnukba.movieapi.MainActivity
import com.alnukba.movieapi.R
import com.alnukba.movieapi.apiServices.Repostary
import com.alnukba.movieapi.apiServices.myApi
import com.alnukba.movieapi.models.detailsModel.Genre
import com.alnukba.movieapi.models.detailsModel.movieDetails
import com.bumptech.glide.Glide
import com.mustafayusef.holidaymaster.networks.networkIntercepter
import com.mustafayusef.holidaymaster.utils.toast
import com.mustafayusef.sharay.database.databaseApp

import com.mustafayusef.sharay.database.entitis.favouriteMovieModel
import kotlinx.android.synthetic.main.fragment_details_movie.*
import kotlinx.android.synthetic.main.progress.*


class detailsMovieFragment : Fragment(),MovieDetailsLesener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_movie, container, false)
    }
    var Movieid:Int = 0
    var flage=false
    private lateinit var viewModel: movieDetailsViewModel
     var idM:Int = 0
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val networkIntercepter= context?.let { networkIntercepter(it) }
        val api= networkIntercepter?.let { myApi(it) }
        val db= context?.let { databaseApp(it) }
        val repostary= Repostary(api!!,db!!)
        val factory= movieDetailsViewModelFactory(repostary)

        viewModel = ViewModelProviders.of(this,factory).get(movieDetailsViewModel::class.java)
        viewModel?.Auth=this
        Movieid =requireArguments().getInt("id")
        viewModel?.GetMovieDetails(Movieid)



        }



    override fun OnStart() {
        progLoading?.visibility=View.VISIBLE
        detailsView?.visibility=View.INVISIBLE
    }

    override fun OnSuccess(details: movieDetails) {
        idM=details.id
        progLoading?.visibility=View.GONE
        detailsView?.visibility=View.VISIBLE
        context?.let {
            Glide.with(it).load(MainActivity.constant.baseImageUrl2+details.backdrop_path)
                .into(imageView)
        }

        movieDetailsTitle?.text=details.title
        rating?.text=details.vote_average.toString()
        genresDetails?.text=getGenres(details.genres)
        timeMovieDetails?.text=details.runtime.toString()+ "m"
        movieDiscription?.text=details.overview

        imageButtonFav?.setOnClickListener {

            var data= favouriteMovieModel(idM,details.backdrop_path,
                genresDetails?.text.toString(),details.overview
                ,details.runtime,details.title,details.vote_average)


            if(!flage){
                viewModel.insertMovie(data)
                imageButtonFav?.setImageResource(R.drawable.ic_baseline_favorite_24)
                flage=true
            }else{
                imageButtonFav?.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                viewModel?.DeleteMovie(idM)
                flage=false
            }}
    }
  fun getGenres(list:List<Genre>):String {
      var s:String=""
      for (i in list){
          s+=i.name+" "
      }
      return s
  }
    override fun onFailer(message: String) {
        progLoading?.visibility=View.GONE
        detailsView?.visibility=View.INVISIBLE
        context?.toast(message)

    }

    override fun onFailerNet(message: String) {
        progLoading?.visibility=View.GONE
        detailsView?.visibility=View.INVISIBLE
        context?.toast(message)
    }

    override fun onSusessInsertMovie(it: Long) {
        context?.toast("Movie added to your list")
    }

    override fun onSusessDeleteMovie(it: Int) {
        context?.toast("Movie deleted from your list")
    }
}