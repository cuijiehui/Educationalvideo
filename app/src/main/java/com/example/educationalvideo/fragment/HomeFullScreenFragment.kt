package com.example.educationalvideo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.OrientationHelper
import cn.jzvd.Jzvd
import com.example.educationalvideo.R
import com.example.educationalvideo.Urls
import com.example.educationalvideo.bean.FullVideoBean
import com.example.educationalvideo.dao.CollectVideoBean
import com.example.educationalvideo.dao.DaoFactory
import com.example.educationalvideo.eventbus.CollectClickEvent
import com.example.educationalvideo.tiktok.OnViewPagerListener
import com.example.educationalvideo.tiktok.TikTokRecyclerViewAdapter
import com.example.educationalvideo.tiktok.ViewPagerLayoutManager
import com.example.educationalvideo.viewModel.Goods
import kotlinx.android.synthetic.main.fragment_home_full_screen.*
import kotlinx.android.synthetic.main.item_tiktok.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * @author cui
 * @data 2020/5/19
 * Description:全部播放的界面
 */
class HomeFullScreenFragment : Fragment() {
    private var mAdapter: TikTokRecyclerViewAdapter? = null
    private var mViewPagerLayoutManager: ViewPagerLayoutManager? = null
    private var mCurrentPosition = -1
    private var dataList = ArrayList<FullVideoBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        mAdapter = TikTokRecyclerViewAdapter(context, dataList)
        mViewPagerLayoutManager = ViewPagerLayoutManager(context, OrientationHelper.VERTICAL)
    }

    private fun initView() {
        rv_tiktok.adapter = mAdapter
        rv_tiktok.layoutManager = mViewPagerLayoutManager
        mViewPagerLayoutManager!!.setOnViewPagerListener(object : OnViewPagerListener {
            override fun onInitComplete() {
                //自动播放第一条
                autoPlayVideo(0)
            }

            override fun onPageRelease(isNext: Boolean, position: Int) {
                if (mCurrentPosition == position) {
                    Jzvd.releaseAllVideos()
                }
            }

            override fun onPageSelected(position: Int, isBottom: Boolean) {
                if (mCurrentPosition == position) {
                    return
                }
                autoPlayVideo(position)
                mCurrentPosition = position
            }
        })
        dataList.clear()
        for (i in 0..9) {
            val fullVideoBean = FullVideoBean()
            fullVideoBean.videoPosters = Urls.videoPosters[0][i]
            fullVideoBean.videoUrls = Urls.videoUrls[3][i]
            fullVideoBean.videoTitles = Urls.videoTitles[0][i]
            dataList.add(fullVideoBean)
        }
        mAdapter!!.notifyDataSetChanged()
    }

    private fun autoPlayVideo(postion: Int) {
        if (rv_tiktok == null || rv_tiktok.getChildAt(0) == null) {
            return
        }
        val player = rv_tiktok.getChildAt(0).videoplayer
        player!!.startVideoAfterPreloading()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_full_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun collectClickEvent(collectClickEvent: CollectClickEvent) {
        var data = dataList[collectClickEvent.position]
        data.isCollect = !data.isCollect
//        var db = DaoFactory.getInstance()!!.getCollectVideo()
//        var collectVideoBean = CollectVideoBean()
//        collectVideoBean.videoPosters = data.videoPosters
//        collectVideoBean.videoTitles = data.videoTitles
//        collectVideoBean.videoUrls = data.videoUrls
//        collectVideoBean.userId = 520
//        collectVideoBean.userName = "cui"
//        collectVideoBean.isCollect = data.isCollect
//        collectVideoBean.collectId = "521"
//        db.insert(collectVideoBean)
//        db.findVideoDataAll()
        mAdapter!!.notifyDataSetChanged()
    }


}
