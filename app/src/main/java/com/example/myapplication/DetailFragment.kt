package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {
    var fragmentActivity: FragmentActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentActivity = context as FragmentActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        view.backBtn.setOnClickListener { fragmentActivity?.goBack() }
        view.passFragReturnBtn.setOnClickListener {
            fragmentActivity?.passValue(fragReturnValueText.text.toString())
        }
        return view
    }
}