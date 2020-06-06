package com.example.educationalvideo

import android.os.Bundle
import com.example.educationalvideo.base.BaseActivity
import com.example.educationalvideo.databinding.ActivityWelcomeBinding
import kotlinx.android.synthetic.main.activity_welcome.*
/**
 * @author cui
 * @data 2020/5/19
 * Description:欢迎界面
 */
class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_welcome
    override val isEventBus: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cb_countdown.setOnClickListener {
            run {
                cb_countdown.start()
            }
        }
    }
}
