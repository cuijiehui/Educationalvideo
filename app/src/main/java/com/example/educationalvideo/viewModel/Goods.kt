package com.example.educationalvideo.viewModel

import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author cui
 * @data 2020/4/1
 * Description:
 */
class Goods (price: String ,title : String , img :  String): BaseObservable(){
    lateinit var price : String
    lateinit var title : String
    lateinit var img : String
    init {
        this.price= price
        this.title= title
        this.img = img
    }
    companion object{
        @BindingAdapter("app:imgs")
        @JvmStatic
        fun setImg(imageView: ImageView,img: String){
            Glide.with(imageView.context).load(img).into(imageView)
        }
    }
}