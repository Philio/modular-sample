package com.example.base.di.com.example.base.databinding

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

object TextInputLayout {

    @BindingAdapter("error") @JvmStatic
    fun error(view: TextInputLayout, error: String?) {
        view.error = error
    }
}
