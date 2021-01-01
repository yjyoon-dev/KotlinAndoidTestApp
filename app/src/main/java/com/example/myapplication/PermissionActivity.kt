package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_permission.*
import java.util.jar.Manifest

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        cameraBtn.setOnClickListener {
            checkPermission()
        }
    }
    fun checkPermission(){
        val cameraPermission = ContextCompat.checkSelfPermission(this,"Manifest.permission.CAMERA")
        if(cameraPermission == PackageManager.PERMISSION_GRANTED){
            startProcess()
        }
        else{
            requestPermission()
        }
    }
    fun startProcess(){
        Toast.makeText(this,"카메라를 실행합니다.",Toast.LENGTH_LONG).show()
    }
    fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf("Manifest.permission.CAMERA"),99)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            99 -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startProcess()
                }
                else{
                    finish()
                }
            }
        }
    }
}