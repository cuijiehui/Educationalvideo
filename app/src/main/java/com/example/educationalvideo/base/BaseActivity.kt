package com.example.educationalvideo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author cui
 * @data 2020/3/24
 * Description:
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(){
    abstract val layoutId : Int
    lateinit var baseDataBinding: T
    var isBackEvent:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         baseDataBinding = DataBindingUtil
             .setContentView(this,
            layoutId)
    }

    /**
     * 处理back键的事件
     * @isBackEvent 默认为false 用于判断是否需要处理back键事件
     */
    override fun onBackPressed() {
        if (isBackEvent) {
            doBackEvent()
        }else{
            super.onBackPressed()
        }
    }

    /**
     * 用于处理back键的方法
     */
    open fun doBackEvent(){

    }
}