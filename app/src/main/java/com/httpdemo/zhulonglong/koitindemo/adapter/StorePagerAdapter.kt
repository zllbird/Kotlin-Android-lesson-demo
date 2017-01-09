package com.httpdemo.zhulonglong.koitindemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.httpdemo.zhulonglong.koitindemo.ui.fargment.StoreGateFragment

/**
 * 干货 viewpager adapter
 * Created by zhulonglong on 2017/1/8.
 */
class StorePagerAdapter(val fragments:List<StoreGateFragment>,fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence = "Android"
}