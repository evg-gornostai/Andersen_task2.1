package com.gornostai.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnToast: Button
    private lateinit var btnCount: Button
    private lateinit var tvShowCount: TextView

    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvShowCount = findViewById(R.id.show_count)

        btnToast = findViewById(R.id.button_toast)
        btnToast.setOnClickListener {
            showToast()
        }

        btnCount = findViewById(R.id.button_count)
        btnCount.setOnClickListener {
            countUp()
        }
    }

    fun showToast(){
        Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT).show()
    }

    fun countUp(){
        mCount++
        tvShowCount.text = mCount.toString()
    }

}