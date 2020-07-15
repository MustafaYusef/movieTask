package com.alnukba.movieapi.ui.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alnukba.movieapi.R
import com.alnukba.movieapi.apiServices.Repostary
import com.alnukba.movieapi.apiServices.myApi
import com.alnukba.movieapi.ui.detailsMovie.movieDetailsViewModel
import com.alnukba.movieapi.ui.detailsMovie.movieDetailsViewModelFactory
import com.mustafayusef.holidaymaster.networks.networkIntercepter
import com.mustafayusef.holidaymaster.utils.toast
import com.mustafayusef.sharay.database.databaseApp
import com.mustafayusef.sharay.database.entitis.favouriteMovieModel
import com.mustafayusef.wakely.ui.main.FavouriteViewModel
import com.mustafayusef.wakely.ui.main.FavouriteViewModelFactory
import com.mustafayusef.wakely.ui.main.MainScreenViewModel
import kotlinx.android.synthetic.main.fragment_favourite_movie.*
import kotlinx.android.synthetic.main.progress.*


/**
 * A simple [Fragment] subclass.
 * Use the [favouriteMovie.newInstance] factory method to
 * create an instance of this fragment.
 */
class favouriteMovie : Fragment(),FavouriteLesener {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_movie, container, false)
    }
    private lateinit var viewModel: FavouriteViewModel
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val networkIntercepter= context?.let { networkIntercepter(it) }
        val api= networkIntercepter?.let { myApi(it) }
        val db= context?.let { databaseApp(it) }
        val repostary= Repostary(api!!,db!!)
        val factory= FavouriteViewModelFactory(repostary)

        viewModel = ViewModelProviders.of(this,factory).get(FavouriteViewModel::class.java)
        viewModel?.Auth=this

        viewModel?.getAllFavouriteMovie()
        FavList?.layoutManager=LinearLayoutManager(context)
    }
    override fun OnStart() {
        progLoading?.visibility=View.VISIBLE

    }

    override fun OnSuccess(FavoutiteRes: List<favouriteMovieModel>) {
        progLoading?.visibility=View.GONE
        FavList?.adapter= context?.let { FavouritemoviesAdapter(it,FavoutiteRes) }
    }

    override fun onFailer(message: String) {
        progLoading?.visibility=View.GONE
        context?.toast(message)

    }


}