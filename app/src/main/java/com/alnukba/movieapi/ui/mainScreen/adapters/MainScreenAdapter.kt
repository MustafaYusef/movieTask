package com.alnukba.movieapi.ui.mainScreen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alnukba.movieapi.R
import com.alnukba.movieapi.models.movieModel.poupolarMovie

import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.first_banners.view.*
import kotlinx.android.synthetic.main.shops_list.view.*

class MainScreenAdapter(
    val context: Context, val banners: poupolarMovie,
    val topRatedMovie: poupolarMovie,
    val upcommingMove: poupolarMovie,
    val nowPlayingMovie: poupolarMovie

) : RecyclerView.Adapter<MainScreenAdapter.CustomViewHolder>(){
//

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // println(holidayFeed)
         if(viewType==0){
             val layoutInflater =LayoutInflater.from(parent.context)
             val cardItem=layoutInflater.inflate(R.layout.first_banners ,parent,false)

             return CustomViewHolder(
                 cardItem
             )
         }
        else{
            val layoutInflater =LayoutInflater.from(parent.context)
             val cardItem=layoutInflater.inflate(R.layout.shops_list,parent,false)

             return CustomViewHolder(
                 cardItem
             )
         }


    }

    override fun getItemCount(): Int {
        // count=holidayFeed!!.count().toString()
    return 4

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 0
        } else {
            return 1
        }
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //holder.view.containerCar.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_in))
        //holder.view. OneContainer.startAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_in_list))

        // holder.view.LogoAir .startAnimation(AnimationUtils.loadAnimation(context,R.anim.left_to_right))
      if(position==0){
          //animation_loadingMain?.visibility=View.GONE
          val adapter =
              bannersAdapter(
                  context!!,
                  banners
              )

          holder.view.storesSlider?.sliderAdapter = adapter

          //  context?.let { Glide.with(it).load(com.mustafayusef.sharay.R.drawable.car).into(carImageD) }
//          holder.view.storeSlider?.setIndicatorAnimation(IndicatorAnimations.WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//          holder.view.storeSlider?.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
         holder.view. storesSlider?.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH

          holder.view. storesSlider?.scrollTimeInSec = 3 //set scroll delay in seconds :
          holder.view. storesSlider?.startAutoCycle()
      }
        else if(position==2){
          holder.view.shopsList?.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
          holder.view.shopsList?.adapter=moviesAdapter(context,topRatedMovie)
          holder.view.titleList?.text="Top Rated Movie"

      }
      else if(position==3){
          holder.view.shopsList?.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
          holder.view.shopsList?.adapter=moviesAdapter(context,upcommingMove)
          holder.view.titleList?.text="Upcomming Movie"

      }
      else if(position==1){

          holder.view.shopsList?.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
          holder.view.shopsList?.adapter=moviesAdapter(context,nowPlayingMovie)
          holder.view.titleList?.text="Now Playing"
      }

    }



    class CustomViewHolder(val view : View ) : RecyclerView.ViewHolder(view){



    }






}

