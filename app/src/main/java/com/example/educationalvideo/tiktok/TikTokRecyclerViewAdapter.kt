package com.example.educationalvideo.tiktok

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.jzvd.JZDataSource
import cn.jzvd.Jzvd
import com.bumptech.glide.Glide
import com.example.educationalvideo.R
import com.example.educationalvideo.Urls
import com.example.educationalvideo.bean.FullVideoBean
import com.example.educationalvideo.eventbus.CollectClickEvent
import kotlinx.android.synthetic.main.item_tiktok.view.*
import org.greenrobot.eventbus.EventBus

/**
 * @author cui
 * @data 2020/5/19
 * Description:列表播放的适配器
 */
class TikTokRecyclerViewAdapter(private val context: Context?,dataList:ArrayList<FullVideoBean>) :
    RecyclerView.Adapter<TikTokRecyclerViewAdapter.MyViewHolder>() {
    internal var videoIndexs = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    var dataList  = ArrayList<FullVideoBean>()
    init {
        this.dataList = dataList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                R.layout.item_tiktok, parent,
                false
            )
        )
    }

    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder [" + holder.jzvdStd.hashCode() + "] position=" + position)
        if (dataList.size<=0){
            return
        }
        val jzDataSource = JZDataSource(
            dataList[position].videoUrls,
            dataList[position].videoTitles
        )
        jzDataSource.looping = true
        holder.jzvdStd.setUp(jzDataSource, Jzvd.SCREEN_NORMAL)
        holder.itemView.collect_btn.setOnClickListener { run {
                EventBus.getDefault().post(CollectClickEvent(position))
        } }
        Glide.with(holder.jzvdStd.getContext()).load(dataList[position].videoPosters)
            .into(holder.jzvdStd.posterImageView)
        holder.itemView.collect_btn.isSelected=dataList[position].isCollect
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var jzvdStd: JzvdStdTikTok
        init {
            jzvdStd = itemView.findViewById<View>(R.id.videoplayer) as JzvdStdTikTok
        }
    }

    companion object {

        val TAG = "AdapterTikTokRecyclerView"
    }

}
