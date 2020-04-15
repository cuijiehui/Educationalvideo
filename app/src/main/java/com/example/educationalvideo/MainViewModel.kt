package com.example.educationalvideo

import com.example.educationalvideo.base.BaseViewModel

/**
 * @author cui
 * @data 2020/3/24
 * Description:
 */
class MainViewModel (var name: String, var sex: String): BaseViewModel (){
    override val viewModelName: String
        get() = "mainViewModel"

}