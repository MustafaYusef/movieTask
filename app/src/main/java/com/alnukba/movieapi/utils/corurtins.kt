package com.mustafayusef.wakely.utils

import com.mustafayusef.holidaymaster.utils.ApiExaptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object corurtins {
    fun main(work:suspend (()->Unit))=
        CoroutineScope(Dispatchers.Main).launch {

                work()


        }

}