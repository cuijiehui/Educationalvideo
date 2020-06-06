package com.example.educationalvideo.activity

import android.app.Activity
import android.os.Bundle
import com.example.educationalvideo.R
import kotlinx.android.synthetic.main.activity_register.*
/**
 * @author cui
 * @data 2020/5/2
 * Description: 注册界面
 */
class RegisterActivity : Activity() {
    var userName =StringBuilder()
    var userPassword = StringBuilder()
    var userPasswordAgain = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        rg_btn_back.setOnClickListener { run {
            finish()
        } }
        rg_user_name_clean.setOnClickListener { run {
            userName.clear()
            rg_user_name.setText(userName.toString())
        } }
        rg_ps_clean.setOnClickListener { run {
            userPassword.clear()
            rg_user_password.setText(userPassword.toString())
        } }
        rg_ps_again_clean.setOnClickListener { run {
            userPasswordAgain.clear()
            rg_ps_again.setText(userPasswordAgain.toString())
        } }
        to_register.setOnClickListener { run {
            //todo 注册接口
        } }

    }

}
