package com.example.educationalvideo.viewModel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import com.example.educationalvideo.activity.LoginActivity
import com.example.educationalvideo.activity.MainHomeActivity
import com.example.educationalvideo.eventbus.LoginEvent
import com.example.educationalvideo.utils.SPApi
import com.example.educationalvideo.utils.SPUtil
import com.google.gson.Gson
import org.greenrobot.eventbus.EventBus

/**
 * @author cui
 * @data 2020/5/26
 * Description:
 */
class LoginHandel(loginModel: LoginModel?, context: Activity) : BaseHandel() {

    var loginModel: LoginModel? = loginModel
    var context: Context = context
    fun onLoginClick(view: View) {

        Log.i("LoginHandel", "onLoginClick=" + loginModel!!.toString())
        var userJsonModel = UserJsonModel(
            loginModel!!.userName
            , loginModel!!.userPassword
            , "账号："
            , "https://img10.360buyimg.com/n7/jfs/t16927/93/942036517/86961/6f1b3a20/5ab3af1bN650b36c0.jpg"
            , true
        )
        var userJson = Gson().toJson(userJsonModel)
        SPUtil.getInstance()!!.put(SPApi.KEY_USER_INFO, userJson)
        EventBus.getDefault().post(LoginEvent())
        context.startActivity(Intent(context, MainHomeActivity::class.java))
        context as LoginActivity
        (context as LoginActivity).finish()
    }

}