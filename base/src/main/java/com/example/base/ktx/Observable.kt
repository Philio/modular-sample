package com.example.base.ktx

import androidx.databinding.Observable

fun <T : Observable> T.onPropertyChanged(callback: (T) -> Unit) =
    addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) = callback(sender as T)
    })
