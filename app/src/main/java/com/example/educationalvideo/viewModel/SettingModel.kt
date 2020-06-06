package com.example.educationalvideo.viewModel

import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author cui
 * @data 2020/5/19
 * Description: 设置界面的model
 */
class SettingModel(switch: Boolean,logoutText:String) {
    var switch :Boolean = switch
    var logoutText :String = logoutText
    companion object{
        @BindingAdapter("app:logout")
        @JvmStatic
        fun setLogoutText(textView: TextView, logoutText :String){
            textView.text=logoutText
        }
    }
}