package com.example.educationalvideo.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import com.example.educationalvideo.R
import com.example.educationalvideo.SettingActivity
import com.example.educationalvideo.base.BaseActivity
import com.example.educationalvideo.eventbus.LoginEvent
import com.example.educationalvideo.utils.SPApi
import com.example.educationalvideo.utils.SPUtil
import com.example.educationalvideo.viewModel.UserJsonModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_basic_info.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
/**
 * @author cui
 * @data 2020/5/2
 * Description: 个人中心界面
 *
 *
 */
class BasicInfoActivity : BaseActivity<com.example.educationalvideo.databinding.ActivityBasicInfoBinding>() {

    var mUserJsonModel : UserJsonModel = UserJsonModel(""
        ,""
        ,"登录"
        ,""
        ,false)
    override val layoutId: Int
        get() = R.layout.activity_basic_info
    override val isEventBus: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }
    fun initView(){
        user_number_click.setOnClickListener { run {
            if (mUserJsonModel.isLogin) {

            }else{
                startActivity(Intent(applicationContext,LoginActivity::class.java))
            }
        } }
        iv_image.setOnClickListener { run {
            if (mUserJsonModel.isLogin) {

            }else{
                startActivity(Intent(applicationContext,LoginActivity::class.java))
            }
        } }
        to_setting.setOnClickListener { run {
            startActivity(Intent(applicationContext,SettingActivity::class.java))
        } }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun loginEvent(loginEvent: LoginEvent){
        finish()
    }
    override fun onResume() {
        super.onResume()
       var userJson = SPUtil.getInstance()!!.get(SPApi.KEY_USER_INFO,"") as String
        if (!TextUtils.isEmpty(userJson)) {
           var gson = Gson()
           var userJsonModel = gson.fromJson<UserJsonModel>(userJson,UserJsonModel::class.java) as UserJsonModel
            if (userJsonModel.isLogin) {
                mUserJsonModel=userJsonModel
            }
        }
        baseDataBinding.userJsonModel=mUserJsonModel
    }
}
