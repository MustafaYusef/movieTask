package com.alnukba.movieapi.ui.favourite


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.alnukba.movieapi.MainActivity
import com.alnukba.movieapi.R
import com.bumptech.glide.Glide

import com.mustafayusef.sharay.database.entitis.favouriteMovieModel
import kotlinx.android.synthetic.main.favourite_movie_card.view.*
import kotlinx.android.synthetic.main.movie_card.view.*


class FavouritemoviesAdapter(
    val context: Context,
    val moviesResponse: List<favouriteMovieModel>
) : RecyclerView.Adapter<FavouritemoviesAdapter.CustomViewHolder>(){
//
 // private  var mOnNotlesener=onNoteLisener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // println(holidayFeed)

        val layoutInflater =LayoutInflater.from(parent.context)
        val cardItem=layoutInflater.inflate(R.layout.favourite_movie_card ,parent,false)

        return  CustomViewHolder(cardItem)
    }

    override fun getItemCount(): Int {
        // count=holidayFeed!!.count().toString()
    return moviesResponse.size

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.favCard.startAnimation(AnimationUtils.loadAnimation(context, R.anim.zoom_in))
        //holder.view. OneContainer.startAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_in_list))

        // holder.view.LogoAir .startAnimation(AnimationUtils.loadAnimation(context,R.anim.left_to_right))

        val data=moviesResponse.get(position)
        if(data.title.length>25){
            holder.view?.movieFavTitleCard.text=data.title.subSequence(0,25).toString()+".."
        }else{
            holder.view?.movieFavTitleCard.text=data.title
        }
        holder.view?.genresFavDetails.text=data.genres
        holder.view?.timeFavDetails.text=data.runtime.toString()+" m"
        Glide.with(context).load(MainActivity.constant.baseImageUrl+data.backdrop_path)
            .into(holder.view?.movieFavImageCard)
        holder.view.setOnClickListener {
            var bundel= Bundle()
            data.id?.let { it1 -> bundel.putInt("id", it1) }


            holder.view.findNavController()?.navigate(R.id.detailsMovieFragment,bundel)

        }
//        val comp=shopsResponse.data.get(position)
//
//        if(comp.title.length>14){
//            holder.view.?.text=comp.title.subSequence(0,13).toString()+".."
//        }else{
//            holder.view. storeTitle?.text=comp.title
//        }
//        holder.view.discStore.visibility=View.GONE
//        Glide.with(context).load("http://api.alwakiel.com/storage/images/"+comp.image)
//            .into(holder.view?.storeImage)

//        Glide.with(context).load("http://api.centralmarketiq.com/"+carsP.image+".png").into(holder.view?.numImage)

    }



    class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view){
//           var OnNotlesener:OnNoteLisener
//        override fun onClick(view: View?) {
//           onNoteLisener.onNoteClick(layoutPosition)
//        }
//
//        init {
//            this.OnNotlesener=onNoteLisener
//         view.setOnClickListener(this)
//
//        }


    }






}

