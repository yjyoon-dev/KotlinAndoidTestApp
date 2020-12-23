package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    var value: Int? = null
    var fragmentActivity: FragmentActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentActivity = context as FragmentActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        view.nextBtn.setOnClickListener { fragmentActivity?.goDetail() }
        view.argText1.text = arguments?.getString("key1")
        view.argText2.text = arguments?.getInt("key2").toString()
        return view
    }

    fun setValue(activityValue: String){
        value = activityValue.toInt()
        argText1.text = value.toString()
        Toast.makeText(fragmentActivity,"Setting value to ${value} completed",Toast.LENGTH_SHORT).show()
    }

    fun receiveValue(receivedValue: String){
        argText2.text = receivedValue
    }
}