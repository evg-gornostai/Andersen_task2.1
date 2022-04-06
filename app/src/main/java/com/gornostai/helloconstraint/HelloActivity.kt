package com.gornostai.helloconstraint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import helloconstraint.R

class HelloActivity : AppCompatActivity() {

    var mcount = 0

    lateinit var tvCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        val intent = intent
        if (intent != null){
            mcount = intent.getIntExtra("count",0)
        }
        tvCount = findViewById(R.id.tv_count_hello)
        tvCount.text = mcount.toString()
    }
}