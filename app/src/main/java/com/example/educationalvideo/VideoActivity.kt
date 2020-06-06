package com.example.educationalvideo

import android.os.Bundle
import com.example.educationalvideo.base.BaseActivity
import com.example.educationalvideo.databinding.ActivityVideoBinding

/**
 * @author cui
 * @data 2020/4/2
 * Description:
 */
class VideoActivity : BaseActivity<ActivityVideoBinding>(){
    override val layoutId: Int
        get() = R.layout.activity_video
    override val isEventBus: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun doBackEvent() {
        super.doBackEvent()
    }
}