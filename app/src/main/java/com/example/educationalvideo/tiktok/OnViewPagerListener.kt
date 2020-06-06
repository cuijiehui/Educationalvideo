package com.example.educationalvideo.tiktok

/**
 * @author cui
 * @data 2020/5/19
 * Description:用于ViewPagerLayoutManager的监听
 */
interface OnViewPagerListener {

    /*初始化完成*/
    fun onInitComplete()

    /*释放的监听*/
    fun onPageRelease(isNext: Boolean, position: Int)

    /*选中的监听以及判断是否滑动到底部*/
    fun onPageSelected(position: Int, isBottom: Boolean)


}
