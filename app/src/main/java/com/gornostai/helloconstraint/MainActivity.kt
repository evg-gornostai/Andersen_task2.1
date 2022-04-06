package com.gornostai.helloconstraint

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import helloconstraint.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnToast: Button
    private lateinit var btnCount: Button
    private lateinit var btnZero: Button
    private lateinit var btnSayHello: Button
    private lateinit var tvShowCount: TextView

    private var mCount = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null){
            mCount = savedInstanceState.getInt("count",0)
        }

        Log.d("MainActivity", "hello from the main screen!")
        Log.i("MainActivity", "hello from the main screen!")
        Log.v("MainActivity", "hello from the main screen!")
        Log.e("MainActivity", "hello from the main screen!")
        Log.w("MainActivity", "hello from the main screen!")

        tvShowCount = findViewById(R.id.show_count)
        tvShowCount.text = mCount.toString()

        btnToast = findViewById(R.id.button_toast)
        btnToast.setOnClickListener {
            showToast()
        }

        btnCount = findViewById(R.id.button_count)
        btnCount.setOnClickListener {
            countUp()
        }

        btnZero = findViewById(R.id.button_zero)
        btnZero.setOnClickListener {
            mCount = 0
            tvShowCount.text = mCount.toString()
            btnZero.setBackgroundColor(resources.getColor(R.color.gray, null))
            btnCount.setBackgroundColor(resources.getColor(R.color.purple_200, null))
        }

        btnSayHello = findViewById(R.id.button_say_hello)
        btnSayHello.setOnClickListener {
            val intent = Intent(this, HelloActivity::class.java)
            intent.putExtra("count", mCount)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mCount != 0) {
            outState.putInt("count", mCount)
        }
    }

    fun showToast() {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun countUp() {
        mCount++
        tvShowCount.text = mCount.toString()
        btnZero.setBackgroundColor(Color.GREEN)
        if (mCount % 2 == 0) {
            btnCount.setBackgroundColor(resources.getColor(R.color.red, null))
        } else {
            btnCount.setBackgroundColor(resources.getColor(R.color.purple_200, null))
        }
    }

}