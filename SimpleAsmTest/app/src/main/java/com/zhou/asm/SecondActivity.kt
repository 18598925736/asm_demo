package com.zhou.asm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityTag", "MainActivity-> SecondActivity")
        setContentView(R.layout.second_layout)
    }
}