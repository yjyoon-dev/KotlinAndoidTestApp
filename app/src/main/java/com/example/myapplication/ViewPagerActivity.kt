package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        Toast.makeText(this,"ViewPager2 지원으로 인해 Fragment 를 이용한 구현을 권장",Toast.LENGTH_LONG).show()
    }
}