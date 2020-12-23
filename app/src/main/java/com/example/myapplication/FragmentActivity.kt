package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.fragment_detail.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        setFragment()
    }

    fun setFragment() {
        var listFragment: ListFragment = ListFragment()
        setFragValueBtn.setOnClickListener {listFragment.setValue(fragValueText.text.toString()) }
        var bundle = Bundle()
        bundle.putString("key1","List Fragment")
        bundle.putInt("key2",20201224)
        listFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }

    fun goDetail(){
        var detailFragment: DetailFragment = DetailFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack(){
        onBackPressed()
    }

    fun passValue(returnValue: String){
        Toast.makeText(this, returnValue, Toast.LENGTH_SHORT).show()
    }
}
