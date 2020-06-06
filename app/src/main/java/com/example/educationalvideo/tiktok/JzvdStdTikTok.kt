package com.example.educationalvideo.tiktok

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import cn.jzvd.JzvdStd
import com.example.educationalvideo.R
/**
 * @author cui
 * @data 2020/5/19
 * Description:全屏自定义view
 */
class JzvdStdTikTok : JzvdStd {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun init(context: Context) {
        super.init(context)
        bottomContainer.visibility = View.GONE
        topContainer.visibility = View.GONE
        bottomProgressBar.visibility = View.GONE
        posterImageView.scaleType = ImageView.ScaleType.FIT_CENTER
    }


    //changeUiTo 真能能修改ui的方法
    override fun changeUiToNormal() {
        super.changeUiToNormal()
        bottomContainer.visibility = View.GONE
        topContainer.visibility = View.GONE
    }

    override fun setAllControlsVisiblity(
        topCon: Int, bottomCon: Int, startBtn: Int, loadingPro: Int,
        posterImg: Int, bottomPro: Int, retryLayout: Int
    ) {
        topContainer.visibility = topCon
        bottomContainer.visibility = bottomCon
        startButton.visibility = startBtn
        loadingProgressBar.visibility = loadingPro
        posterImageView.visibility = posterImg
        bottomProgressBar.visibility = View.GONE
        mRetryLayout.visibility = retryLayout
    }

    override fun dissmissControlView() {
        if (state != STATE_NORMAL
            && state != STATE_ERROR
            && state != STATE_AUTO_COMPLETE
        ) {
            post {
                bottomContainer.visibility = View.INVISIBLE
                topContainer.visibility = View.INVISIBLE
                startButton.visibility = View.INVISIBLE
                if (clarityPopWindow != null) {
                    clarityPopWindow.dismiss()
                }
                if (screen != SCREEN_TINY) {
                    bottomProgressBar.visibility = View.GONE
                }
            }
        }
    }


    override fun onClickUiToggle() {
        super.onClickUiToggle()
        Log.i(TAG, "click blank")
        startButton.performClick()
        bottomContainer.visibility = View.GONE
        topContainer.visibility = View.GONE
    }

    override fun updateStartImage() {
        if (state == STATE_PLAYING) {
            startButton.visibility = View.VISIBLE
            startButton.setImageResource(R.drawable.tiktok_play_tiktok)
            replayTextView.visibility = View.GONE
        } else if (state == STATE_ERROR) {
            startButton.visibility = View.INVISIBLE
            replayTextView.visibility = View.GONE
        } else if (state == STATE_AUTO_COMPLETE) {
            startButton.visibility = View.VISIBLE
            startButton.setImageResource(R.drawable.tiktok_play_tiktok)
            replayTextView.visibility = View.VISIBLE
        } else {
            startButton.setImageResource(R.drawable.tiktok_play_tiktok)
            replayTextView.visibility = View.GONE
        }
    }
}
