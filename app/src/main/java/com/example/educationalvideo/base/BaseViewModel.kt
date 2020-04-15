package com.example.educationalvideo.base

import androidx.lifecycle.ViewModel


/**
 * @author cui
 * @data 2020/3/24
 * Description: viewModel基类
 *
 */
 abstract class BaseViewModel : ViewModel(){
    /**
     * @viewModelName 用于表示 这个viewmodel在view中的名称
     */
    abstract val viewModelName :String

}