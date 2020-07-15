package com.alnukba.movieapi.ui.category

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
import com.alnukba.movieapi.models.categoryModel.categoryModel
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.alnukba.movieapi.ui.category.adapters.categoryAdapter
import com.alnukba.movieapi.ui.detailsMovie.movieDetailsViewModel
import com.alnukba.movieapi.ui.detailsMovie.movieDetailsViewModelFactory
import com.mustafayusef.holidaymaster.networks.networkIntercepter
import com.mustafayusef.holidaymaster.utils.toast
import com.mustafayusef.sharay.database.databaseApp
import kotlinx.android.synthetic.main.fragment_list_movie.*
import kotlinx.android.synthetic.main.progress.*


class listMovieFragment : Fragment(),CategoryLesener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }
  lateinit var viewModel:CategoryViewModel
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val networkIntercepter= context?.let { networkIntercepter(it) }
        val api= networkIntercepter?.let { myApi(it) }
        val db= context?.let { databaseApp(it) }
        val repostary= Repostary(api!!,db!!)
        val factory= CategoryViewModelFactory(repostary)

        viewModel = ViewModelProviders.of(this,factory).get(CategoryViewModel::class.java)
        viewModel?.Auth=this

        viewModel?.GetGenres()
        CategoryList?.layoutManager=LinearLayoutManager(context)

    }
    override fun OnStart() {
        progLoading?.visibility=View.VISIBLE
    }

    override fun OnSuccessGetMovies(details: poupolarMovie) {


    }

    override fun OnSuccessGetGenres(details: categoryModel) {
        progLoading?.visibility=View.GONE
        CategoryList?.adapter= context?.let { categoryAdapter(it,details) }
    }

    override fun onFailer(message: String) {
        context?.toast(message)
        progLoading?.visibility=View.GONE
    }

    override fun onFailerNet(message: String) {
       context?.toast(message)
        progLoading?.visibility=View.GONE
    }


}