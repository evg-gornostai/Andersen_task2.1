package com.gornostai.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast = findViewById(R.id.button_toast)
        btnToast.setOnClickListener {
            showToast()
        }
    }

    fun showToast(){
        Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT).show()
    }

}