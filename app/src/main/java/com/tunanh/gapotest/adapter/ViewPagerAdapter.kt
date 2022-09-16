package com.tunanh.gapotest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tunanh.gapotest.ui.fragment.*

class ViewPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment
    {
        return when (position)
        {
            0 -> HomeFragment()
            1 -> PeopleFragment()
            2 -> MessengerFragment()
            3 -> NotifyFragment()
            4 -> CalendarFragment()
            5 -> AccountFragment()
            else -> HomeFragment()
        }
    }
}