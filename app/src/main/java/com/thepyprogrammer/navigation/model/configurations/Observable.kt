package com.thepyprogrammer.navigation.model.configurations

import androidx.databinding.Observable

inline fun <reified T : Observable>
        T.addOnPropertyChanged(crossinline callback: (T) -> Unit) =
    object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable?, i: Int) =
            callback(observable as T)
    }.also { addOnPropertyChangedCallback(it) }
