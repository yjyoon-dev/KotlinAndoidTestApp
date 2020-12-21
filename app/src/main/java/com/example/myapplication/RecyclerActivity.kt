package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        fun loadData(): MutableList<Memo>{
            var data:MutableList<Memo> = mutableListOf()
            for(no in 1..100){
                var title = "리사이클러뷰 테스트 ${no}"
                var date = System.currentTimeMillis()
                var memo = Memo(no,title,date)
                data.add(memo)
            }
            return data
        }

        val data:MutableList<Memo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data;

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}