package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat

class ViewPageC(context: Context) : LinearLayoutCompat(context){
    init{
        val view = LayoutInflater.from(context).inflate(R.layout.layout_c, this, false)
        addView(view)
    }
}