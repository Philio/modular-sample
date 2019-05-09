package com.example.modularsample

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.create()
}