package com.thepyprogrammer.navigation.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var image = MutableLiveData<String>()

    var pName = MutableLiveData("name")

    fun getResultName() = pName


}