package com.alnukba.movieapi.ui.mainScreen.adapters


import android.content.Context
import android.os.Bundle

import com.smarteist.autoimageslider.SliderViewAdapter
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.alnukba.movieapi.MainActivity
import com.alnukba.movieapi.R
import com.alnukba.movieapi.models.movieModel.poupolarMovie
import kotlinx.android.synthetic.main.slider_layout.view.*


class bannersAdapter(val context: Context,val response: poupolarMovie?) : SliderViewAdapter<bannersAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.slider_layout, null)
        return SliderAdapterVH(
            inflate
        )
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
      //  viewHolder.itemView. .text = "This is slider item $position"
        var data=response!!.results .get(position)

        viewHolder.itemView.setOnClickListener {
            var bundel= Bundle()
            bundel.putInt("id",data.id)


            viewHolder.itemView.findNavController()?.navigate(R.id.detailsMovieFragment,bundel)
//            if(MainActivity.cacheObj.token!=""){
//                var bundel= Bundle()
//                bundel.putString("CompId",data.companyId)
//                bundel.putString("image",data.image)
//                viewHolder.itemView.findNavController()?.navigate(R.id.sections,bundel)
//
//            }
        }
         viewHolder.itemView.titleBanner.text=data.title
            Glide.with(context).load(MainActivity.constant.baseImageUrl+data.backdrop_path)
              .into(  viewHolder.itemView.slid_Image)

//       viewHolder.itemView.setOnClickListener {
//
//           val dview: View = View.inflate(context,R.layout.full_screen, null)
//           val builder = context?.let { AlertDialog.Builder(it,android.R.style.Theme_Black_NoTitleBar_Fullscreen).setView(dview) }
//           val malert= builder?.show()
//
//          // malert?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//           val adapter =sliderAdapterFull(context,imges, img)
//
//           dview?.storeSliderFull?.sliderAdapter = adapter
//
//           //  context?.let { Glide.with(it).load(com.mustafayusef.sharay.R.drawable.car).into(carImageD) }
////          holder.view.storeSlider?.setIndicatorAnimation(IndicatorAnimations.WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
////          holder.view.storeSlider?.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
//          // dview?.storeSliderFull?.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
//           dview?.storeSliderFull?.indicatorSelectedColor = Color.WHITE
//           dview?.storeSliderFull?.indicatorUnselectedColor = Color.GRAY
//          // dview?.storeSliderFull?.scrollTimeInSec = 3 //set scroll delay in seconds :
//           //dview?.storeSliderFull?.startAutoCycle()
//       }

    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return response!!.results.size
    }

     class SliderAdapterVH(var itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
//        var imageViewBackground: ImageView
//        var textViewDescription: TextView

//        init {
//            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider)
//            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider)
//        }
    }
}