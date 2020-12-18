package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var checkBoxListner = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
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

        thread(start=true){
            while(true){
                Thread.sleep(100);
                runOnUiThread {
                    var percentText = progressText.text.toString()
                    progressText.text = (percentText.slice(IntRange(0,percentText.length-2)).toInt()+1).toString() + "%"
                    if(progressText.text == "100%") progressLayout.visibility = View.GONE
                }
            }
        }

        thread(start=true){
            while(true){
                kotlinImage.rotationX -=1
                Thread.sleep(10)
                if(kotlinImage.rotationX==-360f)
                    kotlinImage.rotationX=360f
            }
        }

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

        checkApple.setOnCheckedChangeListener(checkBoxListner)
        checkBanana.setOnCheckedChangeListener(checkBoxListner)
        checkOrange.setOnCheckedChangeListener(checkBoxListner)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekText.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }
        })
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            rateText.text = "$rating"
        }
    }

    fun showProgress(show: Boolean) {
        if(show) progressLayout.visibility = View.VISIBLE
        else progressLayout.visibility = View.GONE
    }

}