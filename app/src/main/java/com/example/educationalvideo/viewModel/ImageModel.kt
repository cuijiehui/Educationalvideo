package com.example.educationalvideo.viewModel

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author cui
 * @data 2020/3/27
 * Description:
 */
class ImageModel(imgUrl : String) :BaseObservable(){
    lateinit var imgUrl : String

    companion object{
        @BindingAdapter("app:img")
        @JvmStatic
        fun setImgUrl(imageView: ImageView,url :String){
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }

}