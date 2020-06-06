package com.example.educationalvideo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.jzvd.Jzvd
import cn.jzvd.JzvdStd
import com.bumptech.glide.Glide
import com.example.educationalvideo.R
import com.example.educationalvideo.Urls
/**
 * @author cui
 * @data 2020/5/15
 * Description:首页viewPage的适配器
 *
 */
class ListVideoAdapter(private val context: Context?) : RecyclerView.Adapter<ListVideoAdapter.MyViewHolder>() {
    internal var videoIndexs = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                R.layout.item_videoview, parent,
                false
            )
        )
    }

    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder [" + holder.jzvdStd.hashCode() + "] position=" + position)

        holder.jzvdStd.setUp(
            Urls.videoUrls[0][position],
            Urls.videoTitles[0][position], Jzvd.SCREEN_NORMAL
        )
        holder.video_name.text=Urls.videoTitles[0][position]
        Glide.with(holder.jzvdStd.context).load(Urls.videoPosters[0][position]).into(holder.jzvdStd.posterImageView)
    }

    override fun getItemCount(): Int {
        return videoIndexs.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var jzvdStd: JzvdStd
        var video_name: TextView

        init {
            jzvdStd = itemView.findViewById(R.id.videoplayer)
            video_name = itemView.findViewById(R.id.video_name)
        }
    }

    companion object {

        val TAG = "AdapterRecyclerView"
    }

}
