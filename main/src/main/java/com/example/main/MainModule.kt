package com.example.main

import com.example.feature1.Feature1Module
import com.example.feature2.Feature2Module
import com.example.feature3.Feature3Module
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector(modules = [Feature1Module::class, Feature2Module::class, Feature3Module::class])
    abstract fun mainActivity(): MainActivity
}