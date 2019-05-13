package com.example.base.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class DaggerAndroidViewModelFactory @Inject constructor(application: Application) :
    ViewModelProvider.AndroidViewModelFactory(application)
