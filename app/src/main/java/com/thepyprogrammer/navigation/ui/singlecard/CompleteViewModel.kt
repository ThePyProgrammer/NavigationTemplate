package com.thepyprogrammer.navigation.ui.singlecard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompleteViewModel : ViewModel() {
    var adapterPosition = MutableLiveData(0)
}