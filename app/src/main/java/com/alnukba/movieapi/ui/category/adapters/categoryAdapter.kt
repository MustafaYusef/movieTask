package com.alnukba.movieapi.ui.category.adapters


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
import com.alnukba.movieapi.models.categoryModel.categoryModel
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.category_card.view.*
import kotlinx.android.synthetic.main.movie_card.view.*


class categoryAdapter(
    val context: Context,
    val moviesResponse: categoryModel
) : RecyclerView.Adapter<categoryAdapter.CustomViewHolder>(){
//
 // private  var mOnNotlesener=onNoteLisener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // println(holidayFeed)

        val layoutInflater =LayoutInflater.from(parent.context)
        val cardItem=layoutInflater.inflate(R.layout.category_card ,parent,false)

        return  CustomViewHolder(cardItem)
    }

    override fun getItemCount(): Int {
        // count=holidayFeed!!.count().toString()
    return moviesResponse.genres.size

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.CategoryCard.startAnimation(AnimationUtils.loadAnimation(context, R.anim.slide_in_left))
        //holder.view. OneContainer.startAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_in_list))

        // holder.view.LogoAir .startAnimation(AnimationUtils.loadAnimation(context,R.anim.left_to_right))

        val data=moviesResponse.genres.get(position)
        holder.view. ctegoryTitleCard?.text=data.name
        holder.view.setOnClickListener {
            var bundel= Bundle()
            bundel.putInt("id",data.id)


            holder.view.findNavController()?.navigate(R.id.movieCategory,bundel)

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

