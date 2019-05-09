package com.example.feature2

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Feature2Module {

    @ContributesAndroidInjector
    abstract fun feature2Fragment(): Feature2Fragment
}