package com.thepyprogrammer.navigation.ui.singlecard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.thepyprogrammer.navigation.R

class SingleCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val completeViewModel = ViewModelProvider(this).get(CompleteViewModel::class.java)
    }
}