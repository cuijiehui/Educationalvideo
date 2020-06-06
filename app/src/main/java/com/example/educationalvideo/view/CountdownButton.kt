package com.example.educationalvideo.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.Button
import androidx.annotation.MainThread
import androidx.appcompat.widget.AppCompatButton
import com.example.educationalvideo.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import java.util.jar.Attributes
import java.util.logging.Handler

/**
 * @author cui
 * @data 2020/4/26
 * Description: 倒计时自定义view
 */
class CountdownButton (mContext: Context, mAttributes: AttributeSet? = null, mDefStyleAttr: Int = R.attr.buttonStyle) : Button(mContext, mAttributes, mDefStyleAttr) {


    constructor(context: Context, attributes: AttributeSet) : this(mContext = context, mAttributes = attributes)

    constructor(context: Context) : this(mContext = context)

    var count: Int = 59
    lateinit var paint: Paint
    lateinit var mGradientDrawable : GradientDrawable
    lateinit var subscribe: Disposable//保存订阅者
    init {
        initView()
    }
    fun initView(){
        //初始化画笔
//        paint= Paint() // 创建画笔
//        paint!!.isAntiAlias = true // 设置画笔抗锯齿（使线条平滑）
//        paint!!.color = Color.parseColor("#ffffff") // 设置画笔颜色
//        paint!!.strokeWidth = 4f // 设置画笔宽度
//        paint!!.style = Paint.Style.STROKE // 设置画笔风格

        //初始化按钮背景样式
        mGradientDrawable = GradientDrawable()  //shape在代码中的使用方式
        mGradientDrawable!!.setColor(Color.argb(100,0,0,255)) //按钮背景颜色
        mGradientDrawable!!.cornerRadius = 30f //按钮圆角度
        background = mGradientDrawable
    }
    fun start() {
        isClickable = false//禁用点击,防止重复操作
        text = "${count + 1}s"
        subscribe = Observable.interval(1, TimeUnit.SECONDS)//按时间间隔发送整数的Observable
            .observeOn(AndroidSchedulers.mainThread())//切换到主线程修改UI
            .subscribe {
                val show = count - it
                if (show < 0.toLong()) {//当倒计时小于0,计时结束
                    stop()
                    return@subscribe//使用标记跳出方法
                }
                text = "${show}s"
            }
    }

    /**
     * 结束计时,重新开始
     */
    fun stop() {
        subscribe.dispose()//取消订阅
        text = "重新获取"
        isClickable = true//重新开启点击事件
        return
    }
}