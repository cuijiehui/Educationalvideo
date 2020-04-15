package com.example.educationalvideo

import android.os.Bundle
import com.example.educationalvideo.base.BaseActivity

/**
 * @author cui
 * @data 2020/4/2
 * Description:
 */
class VideoActivity : BaseActivity<com.example.educationalvideo.databinding.ActivityVideoBinding>(){
    override val layoutId: Int
        get() = R.layout.activity_video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun doBackEvent() {
        super.doBackEvent()
    }
}