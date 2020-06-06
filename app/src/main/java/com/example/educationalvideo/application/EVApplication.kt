package com.example.educationalvideo.application

import android.app.Application
import com.example.educationalvideo.dao.MyDbManeger
import com.example.educationalvideo.utils.SPUtil

/**
 * @author cui
 * @data 2020/4/14
 * Description:application
 */
class EVApplication : Application(){
    val application :EVApplication =this
    override fun onCreate() {
        super.onCreate()
        SPUtil.init(this)
        MyDbManeger.init(this)
    }

}