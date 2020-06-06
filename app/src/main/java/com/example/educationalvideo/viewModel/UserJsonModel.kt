package com.example.educationalvideo.viewModel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author cui
 * @data 2020/5/19
 * Description:用户信息model
 */
class UserJsonModel(userName:String,userNumber:String,userNumberTx:String,iconUrl:String,isLogin:Boolean) {
    var userName : String = userName
    var userNumber : String = userNumber
    var userNumberTx : String = userNumberTx
    var iconUrl : String = iconUrl
    var isLogin : Boolean = isLogin
    companion object{
        @BindingAdapter("app:img")
        @JvmStatic
        fun setIconUrl(imageView: ImageView, iconUrl :String){
            Glide.with(imageView.context).load(iconUrl).into(imageView)
        }
    }
}