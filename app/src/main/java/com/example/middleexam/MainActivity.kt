package com.example.middleexam

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.middleexam.Tool.BaseActivity

class MainActivity :BaseActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val window=window
        transparentStatusBar(window)
        val tool=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tool)

    }
}