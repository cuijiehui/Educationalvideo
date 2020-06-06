package com.example.educationalvideo.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.educationalvideo.R
import com.example.educationalvideo.databinding.ActivityLoginBinding
import com.example.educationalvideo.eventbus.LoginEvent
import com.example.educationalvideo.utils.SPApi
import com.example.educationalvideo.utils.SPUtil
import com.example.educationalvideo.viewModel.LoginHandel
import com.example.educationalvideo.viewModel.LoginModel
import com.example.educationalvideo.viewModel.TitleHandel
import com.example.educationalvideo.viewModel.UserJsonModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.include_title_layout.*
import org.greenrobot.eventbus.EventBus

/**
 * @author cui
 * @data 2020/5/4
 * Description: 登录界面
 */
class LoginActivity : Activity() {
    var userName = StringBuilder()
    var userPassword = StringBuilder()
    var loginModel:LoginModel?=null
    var loginHandel : LoginHandel?=null
    var titleHandel: TitleHandel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginModel= LoginModel("","")
        loginHandel= LoginHandel(loginModel,this)
        titleHandel=TitleHandel("登录")
        var binding =DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        loginHandel!!.rootView=binding.root
        binding.loginHandel=loginHandel
        binding.loginModel=loginModel
        binding.titleHandel=titleHandel
        initView()
    }

    private fun initView() {
//        btn_back.setOnClickListener{run{
//            finish()
//        }}
        right_name.setOnClickListener { run{
            startActivity(Intent(this,RegisterActivity::class.java))
        } }
        user_name.setOnFocusChangeListener { view, hasFocus ->
            run {
                if (hasFocus) {
                    name_background.visibility = View.VISIBLE
                } else {
                    name_background.visibility = View.GONE
                }
            }
        }
        user_password.setOnFocusChangeListener { view, hasFocus ->
            run {
                if (hasFocus) {
                    password_background.visibility = View.VISIBLE
                } else {
                    password_background.visibility = View.GONE
                }
            }
        }
        right_name.visibility=View.VISIBLE
//        user_name_clean.setOnClickListener { run{
//            userName.clear()
//            user_name.setText(userName)
//        } }
//        user_password_clean.setOnClickListener { run{
//            userPassword.clear()
//            user_password.setText(userPassword)
//        } }
//        to_login.setOnClickListener { run{
//           var userNmaeText = user_name.text
//           var userPasswordText = user_password.text
//            var userJsonModel = UserJsonModel(userNmaeText.toString()
//                ,userNmaeText.toString()
//                ,"账号："
//                ,"https://img10.360buyimg.com/n7/jfs/t16927/93/942036517/86961/6f1b3a20/5ab3af1bN650b36c0.jpg"
//                ,true
//            )
//            var userJson = Gson().toJson(userJsonModel)
//            SPUtil.getInstance()!!.put(SPApi.KEY_USER_INFO,userJson)
//            EventBus.getDefault().post(LoginEvent())
//            startActivity(Intent(applicationContext,MainHomeActivity::class.java))
//            finish()
//        } }
    }

}
