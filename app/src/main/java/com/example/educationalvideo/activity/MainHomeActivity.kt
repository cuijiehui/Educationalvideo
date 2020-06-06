package com.example.educationalvideo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationalvideo.BR
import com.example.educationalvideo.R
import com.example.educationalvideo.adapter.ClassifyAdapter
import com.example.educationalvideo.adapter.HomePageAdapter
import com.example.educationalvideo.eventbus.ClassifyClickEvent
import com.example.educationalvideo.fragment.HomeFullScreenFragment
import com.example.educationalvideo.fragment.ListPlayFragment
import com.example.educationalvideo.utils.SPApi
import com.example.educationalvideo.utils.SPUtil
import com.example.educationalvideo.viewModel.ClassifyModel
import kotlinx.android.synthetic.main.activity_main_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
/**
 * @author cui
 * @data 2020/4/9
 * Description:主页
 */
class MainHomeActivity : AppCompatActivity() {
    var listData = ArrayList<ClassifyModel>()
    var classifyAdapter:ClassifyAdapter<ClassifyModel> ?= null
    var homePageAdapter:HomePageAdapter ?= null
    var switch = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        SPUtil.init(this)
        EventBus.getDefault().register(this)
        initView()
        initListenner()
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun classifyClickEvent(classifyClickEvent: ClassifyClickEvent){
        listData[classifyClickEvent.oldPosition].enable=false
        listData[classifyClickEvent.position].enable=true
        classifyAdapter!!.notifyDataSetChanged()
    }

    private fun initListenner() {
        tv_home.setOnClickListener { run {
        } }
        tv_mine.setOnClickListener { run {
            startActivity(Intent(this,BasicInfoActivity::class.java))
        } }
    }

    private fun initView(){
        var listdata = ArrayList<Fragment>()
        listdata.add(HomeFullScreenFragment())
        listdata.add(ListPlayFragment())
        homePageAdapter = HomePageAdapter(listdata,supportFragmentManager,1)
        home_page.adapter=homePageAdapter
        listData.clear()
        listData.add(ClassifyModel(0,"推荐",true))
        listData.add(ClassifyModel(1,"数学",false))
        listData.add(ClassifyModel(2,"英语",false))
        listData.add(ClassifyModel(3,"科学",false))
        listData.add(ClassifyModel(4,"生活",false))
        listData.add(ClassifyModel(5,"化学",false))
        classifyAdapter = ClassifyAdapter<ClassifyModel>(applicationContext,layoutInflater,listData,BR.classifyModel)
        rv_classify.adapter=classifyAdapter
        rv_classify.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun onResume() {
        super.onResume()
        switch = SPUtil.getInstance()!!.get(SPApi.KEY_SWITCH_IS_FULL,false) as Boolean
        if (switch) {
            home_page!!.currentItem=0
        }else{
            home_page!!.currentItem=1
        }
    }

}
