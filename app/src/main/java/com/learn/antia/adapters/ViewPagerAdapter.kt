package com.learn.antia.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.learn.antia.fragments.FirstFragment
import com.learn.antia.fragments.SecondFragment
import com.learn.antia.fragments.ThirdFragment

class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val fragments = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )

    override fun getItemCount() = fragments.count()

    override fun createFragment(position: Int) = fragments[position]
}
