package com.example.educationalvideo

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cn.jzvd.JZUtils
import cn.jzvd.Jzvd

/**
 * 列表自动播放工具类
 *
 * @author Liberations
 */
object AutoPlayUtils {
    var positionInList = -1//记录当前播放列表位置

    /**
     * @param firstVisiblePosition 首个可见item位置
     * @param lastVisiblePosition  最后一个可见item位置
     */
    fun onScrollPlayVideo(
        recyclerView: RecyclerView,
        jzvdId: Int,
        firstVisiblePosition: Int,
        lastVisiblePosition: Int
    ) {
        if (JZUtils.isWifiConnected(recyclerView.context)) {
            for (i in 0..lastVisiblePosition - firstVisiblePosition) {
                val child = recyclerView.getChildAt(i)
                val view = child.findViewById<View>(jzvdId)
                if (view != null && view is Jzvd) {
                    if (getViewVisiblePercent(view) == 1f) {
                        if (positionInList != i + firstVisiblePosition) {
                            view.startButton.performClick()
                        }
                        break
                    }
                }
            }
        }
    }

    /**
     * @param firstVisiblePosition 首个可见item位置
     * @param lastVisiblePosition  最后一个可见item位置
     * @param percent              当item被遮挡percent/1时释放,percent取值0-1
     */
    fun onScrollReleaseAllVideos(firstVisiblePosition: Int, lastVisiblePosition: Int, percent: Float) {
        if (Jzvd.CURRENT_JZVD == null) return
        if (positionInList >= 0) {
            if (positionInList <= firstVisiblePosition || positionInList >= lastVisiblePosition - 1) {
                if (getViewVisiblePercent(Jzvd.CURRENT_JZVD) < percent) {
                    Jzvd.releaseAllVideos()
                }
            }
        }
    }

    /**
     * @param view
     * @return 当前视图可见比列
     */
    fun getViewVisiblePercent(view: View?): Float {
        if (view == null) {
            return 0f
        }
        val height = view.height.toFloat()
        val rect = Rect()
        if (!view.getLocalVisibleRect(rect)) {
            return 0f
        }
        val visibleHeight = (rect.bottom - rect.top).toFloat()
        return visibleHeight / height
    }
}
