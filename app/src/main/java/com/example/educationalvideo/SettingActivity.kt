package com.example.educationalvideo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import com.example.educationalvideo.activity.LoginActivity
import com.example.educationalvideo.activity.MainHomeActivity
import com.example.educationalvideo.base.BaseActivity
import com.example.educationalvideo.eventbus.LoginEvent
import com.example.educationalvideo.eventbus.SwitchClickEvent
import com.example.educationalvideo.utils.SPApi
import com.example.educationalvideo.utils.SPUtil
import com.example.educationalvideo.viewModel.SettingModel
import com.example.educationalvideo.viewModel.UserJsonModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.include_title_layout.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
/**
 * @author cui
 * @data 2020/5/19
 * Description:设置界面
 */
class SettingActivity : BaseActivity<com.example.educationalvideo.databinding.ActivitySettingBinding>() {
    var switch = false
    var settingModel = SettingModel(false,"登录")
    var gson = Gson()
    var isLogin :Boolean = false

    override val layoutId: Int
        get() = R.layout.activity_setting
    override val isEventBus: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }
    fun initView(){
        title_name.text = "设置"
        login_logout.setOnClickListener { run {
            if (isLogin) {
                SPUtil.getInstance()!!.put(SPApi.KEY_USER_INFO,"")
                startActivity(Intent(applicationContext,MainHomeActivity::class.java))
                finish()
            }else{
                startActivity(Intent(applicationContext,LoginActivity::class.java))

            }
        } }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun switchClickEvent(switchClickEvent: SwitchClickEvent){
        SPUtil.getInstance()!!.put(SPApi.KEY_SWITCH_IS_FULL,switchClickEvent!!.switch)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun loginEvent(loginEvent: LoginEvent){
        finish()
    }
    override fun onResume() {
        super.onResume()
        switch =  SPUtil.getInstance()!!.get(SPApi.KEY_SWITCH_IS_FULL,false) as Boolean
        settingModel.switch=switch
        var userJson =  SPUtil.getInstance()!!.get(SPApi.KEY_USER_INFO,"") as String
        if (!TextUtils.isEmpty(userJson)) {
            isLogin=gson.fromJson<UserJsonModel>(userJson,UserJsonModel::class.java).isLogin
        }
        if (isLogin) {
            settingModel.logoutText = "注销"
        }else{
            settingModel.logoutText = "登录"
        }
        baseDataBinding.settingModel=settingModel
    }
}
