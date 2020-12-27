package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_fragment_pager.*
import kotlinx.android.synthetic.main.activity_view_pager.*
import com.example.myapplication.FragmentD as FragmentD

class FragmentPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_pager)

        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        fragmentPager.adapter = adapter

        val tabLayout = this.findViewById<TabLayout>(R.id.fragmentTabLayout)
        TabLayoutMediator(tabLayout, fragmentPager) {tab, position ->
            val name :Char = (65 + position).toChar()
            tab.text = name.toString()
        }.attach()
    }
}