package com.thepyprogrammer.navigation.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
}