package com.example.educationalvideo.viewModel

import androidx.databinding.ObservableField
import com.example.educationalvideo.base.BaseViewModel
import kotlin.collections.ArrayList

/**
 * @author cui
 * @data 2020/3/24
 * Description:
 */
class RVViewModel : BaseViewModel() {
    var mDataList = ObservableField<List<String>>()

    override val viewModelName: String
        get() = "rVViewModel"
    fun changeDataList(dataList : List<String>){
        mDataList.set(dataList)
    }
    fun clearDataList(){
        mDataList= ObservableField<List<String>>()
    }
}