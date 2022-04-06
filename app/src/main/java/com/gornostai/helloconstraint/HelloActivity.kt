package com.gornostai.helloconstraint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import helloconstraint.R

class HelloActivity : AppCompatActivity() {

    var mCount = 0

    lateinit var tvCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val intent = intent
        if (intent != null) {
            mCount = intent.getIntExtra("count", 0)
        }
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count", 0)
        }

        tvCount = findViewById(R.id.tv_count_hello)
        tvCount.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mCount != 0) {
            outState.putInt("count", mCount)
        }
    }

}