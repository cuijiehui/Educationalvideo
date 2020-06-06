package com.example.educationalvideo.viewModel

import android.util.Log
import android.view.View

/**
 * @author cui
 * @data 2020/5/26
 * Description:
 */
class TitleHandel(titleName:String){
    var titleName:String = titleName
    fun onBackClick(view:View){
        Log.i("TitleHandel","onBackClick")
    }
}