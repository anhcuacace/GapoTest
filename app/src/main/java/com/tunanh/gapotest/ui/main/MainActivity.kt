package com.tunanh.gapotest.ui.main

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.tunanh.gapotest.R
import com.tunanh.gapotest.adapter.ViewPagerAdapter
import com.tunanh.gapotest.databinding.ActivityMainBinding
import com.tunanh.gapotest.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(), View.OnClickListener {
    override fun layoutRes(): Int = R.layout.activity_main

    override fun initEvents() {
        binding.itemHome.setOnClickListener(this)
        binding.itemPeople.setOnClickListener(this)
        binding.itemMessenger.setOnClickListener(this)
        binding.itemBell.setOnClickListener(this)
        binding.itemCalendar.setOnClickListener(this)
        binding.itemPerson.setOnClickListener(this)
    }

    override fun initControls() {
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        removeAllCheck()
                        binding.itemHome.isCheck()
                    }
                    1 -> {
                        removeAllCheck()
                        binding.itemPeople.isCheck()
                    }
                    2 -> {
                        removeAllCheck()
                        binding.itemMessenger.isCheck()
                    }
                    3 -> {
                        removeAllCheck()
                        binding.itemBell.isCheck()
                    }
                    4 -> {
                        removeAllCheck()
                        binding.itemCalendar.isCheck()
                    }
                    5 -> {
                        removeAllCheck()
                        binding.itemPerson.isCheck()
                    }

                }
            }
        })
    }

    private fun removeAllCheck() {
        binding.itemHome.isNotCheck()
        binding.itemPeople.isNotCheck()
        binding.itemMessenger.isNotCheck()
        binding.itemBell.isNotCheck()
        binding.itemCalendar.isNotCheck()
        binding.itemPerson.isNotCheck()
    }

    override fun onClick(v: View?) {
        binding.apply {
            when (v) {
                itemHome -> viewPager.currentItem = 0
                itemPeople -> viewPager.currentItem = 1
                itemMessenger -> viewPager.currentItem = 2
                itemBell -> viewPager.currentItem = 3
                itemCalendar -> viewPager.currentItem = 4
                itemPerson -> viewPager.currentItem = 5
            }
        }
    }
}