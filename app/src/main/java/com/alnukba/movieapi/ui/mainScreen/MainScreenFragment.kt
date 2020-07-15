package com.alnukba.movieapi.ui.mainScreen

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
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.alnukba.movieapi.ui.mainScreen.adapters.MainScreenAdapter
import com.mustafayusef.holidaymaster.networks.networkIntercepter
import com.mustafayusef.holidaymaster.utils.toast
import com.mustafayusef.sharay.database.databaseApp
import com.mustafayusef.wakely.ui.main.MainScreenViewModel
import com.mustafayusef.wakely.ui.main.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_main_screen.*
import kotlinx.android.synthetic.main.progress.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreenFragment : Fragment(),MainLesener {
    private lateinit var viewModel: MainScreenViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val networkIntercepter= context?.let { networkIntercepter(it) }
        val api= networkIntercepter?.let { myApi(it) }
        val db= context?.let { databaseApp(it) }
        val repostary= Repostary(api!!,db!!)
        val factory= MainViewModelFactory(repostary)

        viewModel = ViewModelProviders.of(this,factory).get(MainScreenViewModel::class.java)
        viewModel?.Auth=this

        ListMain?.layoutManager = LinearLayoutManager(context)
        viewModel?.GetMain()
    }

    override fun OnStart() {
        progLoading?.visibility=View.VISIBLE
    }

    override fun OnSuccess(
        popularRes: poupolarMovie,
        topRatedMovie: poupolarMovie,
        upcommingMove: poupolarMovie,
        nowPlayingMovie: poupolarMovie
    ) {
        ListMain?.adapter = context?.let {
            MainScreenAdapter(
                it, popularRes, topRatedMovie, upcommingMove
                , nowPlayingMovie
            )
        }
        progLoading?.visibility=View.GONE
    }

    override fun onFailer(message: String) {
        progLoading?.visibility=View.GONE
        context?.toast(message)
    }

    override fun onFailerNet(message: String) {
        progLoading?.visibility=View.GONE
        context?.toast(message)
    }

}