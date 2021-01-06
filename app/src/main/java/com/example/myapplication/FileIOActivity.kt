package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_file_i_o.*
import java.io.*

class FileIOActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_i_o)

        fileReadBtn.setOnClickListener {
            fileTextOutput.text = readTextFile("${filesDir}/${readFileName.text}")
        }

        fileWriteBtn.setOnClickListener {
            writeTextFile(filesDir.toString(), fileNameInput.text.toString(), fileTextInput.text.toString())
        }
    }

    fun readTextFile(fullpath: String): String{
        val file = File(fullpath)
        if(!file.exists()) return ""

        val reader = FileReader(file)
        val buffer = BufferedReader(reader)

        var temp = ""
        val result = StringBuffer()

        while(true){
            temp = buffer.readLine()
            if(temp == null) break
            else result.append(buffer)
        }

        buffer.close()
        return result.toString()
    }

    fun writeTextFile(directory: String, filename: String, content: String){
        val dir = File(directory)
        if(!dir.exists()) dir.mkdirs()

        val writer = FileWriter(directory + "/" + filename)
        val buffer = BufferedWriter(writer)

        buffer.write(content)
        buffer.close()

        IOStatusText.text = "File Writing Success!"
    }
}