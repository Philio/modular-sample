package com.example.feature1

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Feature1Module {

    @ContributesAndroidInjector
    abstract fun feature1Fragment(): Feature1Fragment
}