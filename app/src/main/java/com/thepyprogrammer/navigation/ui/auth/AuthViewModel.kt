package com.thepyprogrammer.navigation.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var pName = MutableLiveData("")
    var password = MutableLiveData("")
}