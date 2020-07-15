package com.mustafayusef.holidaymaster.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context

import android.view.View
import android.widget.Toast
import com.alnukba.movieapi.models.detailsModel.Genre
import com.google.android.material.snackbar.Snackbar
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


fun Context.toast(message:String){
    Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
}
fun View.snackbar(message:String){
    Snackbar.make(this,message,Snackbar.LENGTH_LONG).also {snackbar->
        snackbar.setAction("OK"){
           snackbar.dismiss()
        }
    }.show()

}



