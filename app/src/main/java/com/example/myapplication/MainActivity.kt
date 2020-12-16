package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.CompoundButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var checkBoxLister = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        when(buttonView.id){
            R.id.checkApple -> Log.d("check","사과를")
            R.id.checkBanana -> Log.d("check","바나나를")
            R.id.checkOrange -> Log.d("check","오렌지를")
        }
        if(isChecked) Log.d("check","선택하였습니다")
        else Log.d("check","해제하였습니다")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("EditText","현재 입력된 값=${s.toString()}")
            }
        })

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                R.id.radioRed -> {Log.d("radio","빨강선택")}
                R.id.radioBlue -> {Log.d("radio","파랑선택")}
                R.id.radioGreen -> {Log.d("radio","초록선택")}
            }
        }

        checkApple.setOnCheckedChangeListener(checkBoxLister)
        checkBanana.setOnCheckedChangeListener(checkBoxLister)
        checkOrange.setOnCheckedChangeListener(checkBoxLister)
    }
}