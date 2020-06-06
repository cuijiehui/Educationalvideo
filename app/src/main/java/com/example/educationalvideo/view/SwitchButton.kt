package com.example.educationalvideo.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.educationalvideo.R
import android.graphics.Canvas
import android.graphics.RectF
import com.example.educationalvideo.eventbus.SwitchClickEvent
import org.greenrobot.eventbus.EventBus


/**
 * @author cui
 * @data 2020/5/18
 * Description: 开关自定义view
 */
class SwitchButton(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var selectedBg: Int
    private var mUnSelectBg: Int
    private var mCircleMargin : Float
    var switchState : Boolean
    private var mPaint = Paint()
    //默认的宽度
    private val mDefaultWidth = 100f
    //圆弧半径
    private val mDefaultRx = 45f
    init {
        var typeArray = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton)
        selectedBg = typeArray.getColor(R.styleable.SwitchButton_selectedBg, Color.GREEN)
        mUnSelectBg = typeArray.getColor(R.styleable.SwitchButton_unselectedBg, Color.GRAY)
        mCircleMargin = typeArray.getDimension(R.styleable.SwitchButton_circle2Bgmargin, 10f)
        switchState = typeArray.getBoolean(R.styleable.SwitchButton_switchState, false)
        typeArray.recycle()
        initView()
    }
    fun initView(){
        mPaint.isAntiAlias=true
        setOnClickListener { run {
            switchState = !switchState
            EventBus.getDefault().post(SwitchClickEvent(switchState))
            invalidate()
        } }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = View.MeasureSpec.getSize(widthMeasureSpec)
        var width = 0f
        if (widthMode == View.MeasureSpec.EXACTLY) {
            width = widthSize.toFloat()
        } else {
            width = mDefaultWidth
        }

        setMeasuredDimension(width.toInt(), (width / 2).toInt())
    }

    override fun onDraw(canvas: Canvas?) {
        if (switchState) {
            drawOpen(canvas)
        }   else{
            drawClose(canvas)
        }
    }
    private fun drawOpen(canvas: Canvas?) {
        mPaint.color = selectedBg
        //画背景
        val rectF = RectF(0f, 0f, width.toFloat(), (width / 2).toFloat())
        canvas!!.drawRoundRect(rectF, mDefaultRx, mDefaultRx, mPaint)
        //画圆
        mPaint.color = Color.WHITE
        canvas!!.drawCircle(mDefaultWidth * 3 / 4, mDefaultWidth / 4, mDefaultWidth / 4 - mCircleMargin, mPaint)
    }

    private fun drawClose(canvas: Canvas?) {
        mPaint.color = mUnSelectBg
        //画背景
        val rectF = RectF(0f, 0f, width.toFloat(), (width / 2).toFloat())
        canvas!!.drawRoundRect(rectF, mDefaultRx, mDefaultRx, mPaint)
        //画圆
        mPaint.color = Color.WHITE
        canvas!!.drawCircle(mDefaultWidth / 4, mDefaultWidth / 4, mDefaultWidth / 4 - mCircleMargin, mPaint)

    }
}