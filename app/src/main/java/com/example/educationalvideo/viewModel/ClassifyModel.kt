package com.example.educationalvideo.viewModel

import androidx.databinding.BaseObservable

/**
 * @author cui
 * @data 2020/5/15
 * Description: 视频分类的model
 */
class ClassifyModel(id : Int ,name:String,enable:Boolean) : BaseObservable(){
    var id:Int = id
    var name:String = name
    var enable:Boolean = enable
    override fun toString(): String {
        return "ClassifyModel(id=$id, name='$name', enable=$enable)"
    }

}