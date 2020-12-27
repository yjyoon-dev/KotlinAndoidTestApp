package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat

class ViewPageD(context: Context) : LinearLayoutCompat(context){
    init{
        val view = LayoutInflater.from(context).inflate(R.layout.layout_d, this, false)
        addView(view)
    }
}