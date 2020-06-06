package com.example.educationalvideo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.jzvd.Jzvd
import com.example.educationalvideo.AutoPlayUtils
import com.example.educationalvideo.R
import com.example.educationalvideo.adapter.ListVideoAdapter
import kotlinx.android.synthetic.main.fragment_list_play.*

/**
 * @author cui
 * @data 2020/5/19
 * Description:列表播放视频的界面
 */
class ListPlayFragment : Fragment() {
    private var mAdapter :ListVideoAdapter?=null
    private var mLayoutManager :LinearLayoutManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = ListVideoAdapter(context)
        mLayoutManager = LinearLayoutManager(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }
    private fun initView(){
        list_play.adapter=mAdapter
        list_play.layoutManager = mLayoutManager

//        list_play.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {
//            override fun onChildViewAttachedToWindow(view: View) {
//
//            }
//
//            override fun onChildViewDetachedFromWindow(view: View) {
//                val jzvd = view.findViewById<Jzvd>(R.id.videoplayer)
//                if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
//                    jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.currentUrl)
//                ) {
//                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
//                        Jzvd.releaseAllVideos()
//                    }
//                }
//            }
//        })
//        list_play.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    AutoPlayUtils.onScrollPlayVideo(
//                        recyclerView,
//                        R.id.videoplayer,
//                        mLayoutManager!!.findFirstVisibleItemPosition(),
//                        mLayoutManager!!.findLastVisibleItemPosition()
//                    )
//                }
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if (dy != 0) {
//                    AutoPlayUtils.onScrollReleaseAllVideos(
//                        mLayoutManager!!.findFirstVisibleItemPosition(),
//                        mLayoutManager!!.findLastVisibleItemPosition(),
//                        0.2f
//                    )
//                }
//            }
//        })
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
}
