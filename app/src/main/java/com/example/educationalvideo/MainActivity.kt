package com.example.educationalvideo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationalvideo.adapter.CommonRecyclerAdapter
import com.example.educationalvideo.base.BaseActivity
import com.example.educationalvideo.viewModel.Goods
import com.example.educationalvideo.viewModel.ImageModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : BaseActivity<com.example.educationalvideo.databinding.ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val vv =  MainViewModel("cui","woman")
        baseDataBinding.mainViewModel = vv
        baseDataBinding.mainViewModel!!.name ="11"
        isBackEvent = true
        var imgModel  =  ImageModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585311475126&di=5207230e7b9bc6ab0a00c495e38d18a9&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg")
        baseDataBinding.imageViewModel = imgModel
        imgModel.imgUrl= "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585311475126&di=5207230e7b9bc6ab0a00c495e38d18a9&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg"
//        baseDataBinding.rvDataList
        var dataList = ArrayList<Goods>()
        for (i in 1..10){
            dataList.add(Goods("12.9"+i,"我是标题"+i,"https://img10.360buyimg.com/n7/jfs/t16927/93/942036517/86961/6f1b3a20/5ab3af1bN650b36c0.jpg"))
        }
        var goodsAdapter = CommonRecyclerAdapter<Goods>(this,
            layoutInflater
        )
        goodsAdapter.lists=dataList
        goodsAdapter.layoutId = R.layout.item_list_data
        goodsAdapter.variableId = BR.goods
        baseDataBinding.rvDataList.layoutManager = LinearLayoutManager(this)
        baseDataBinding.rvDataList.adapter = goodsAdapter
        video.setOnClickListener {
            run {
                startActivity(Intent(this, JiaoZiActivity::class.java))
            }
        }
        retrofit.setOnClickListener {
            run {
                makeRetrofit()
            }
        }
    }
    override fun doBackEvent(){
        Toast.makeText(applicationContext,"doBackEvent",Toast.LENGTH_SHORT).show()
    }

    fun makeRetrofit(){
        Retrofit.Builder().baseUrl("http://www.baidu.com").build()
    }
}
