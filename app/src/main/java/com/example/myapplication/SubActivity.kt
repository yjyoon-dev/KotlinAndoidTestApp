package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        var spinData = listOf("-선택하세요-","월","화","수","목","금","토","일")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, spinData)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinText.text = spinData.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        closeButton.setOnClickListener {
            var returnIntent = Intent()
            returnIntent.putExtra("returnValue", spinText.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        openRecyclerButton.setOnClickListener {
            val intent = Intent(this,RecyclerActivity::class.java)
            startActivity(intent)
        }

        openFragmentButton.setOnClickListener {
            val intent = Intent(this,FragmentActivity::class.java)
            startActivity(intent)

        }

        customViewBtn.setOnClickListener {
            val intent = Intent(this,CustomViewActivity::class.java)
            startActivity(intent)
        }
    }
}