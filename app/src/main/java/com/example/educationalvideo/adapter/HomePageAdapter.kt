package com.example.educationalvideo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @author cui
 * @data 2020/5/15
 * Description:首页viewPage的适配器
 *
 */
class HomePageAdapter (list: ArrayList<Fragment>,fragmentManager: FragmentManager,behavior:Int): FragmentPagerAdapter(fragmentManager,behavior) {
    private var list:ArrayList<Fragment> = list
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

}