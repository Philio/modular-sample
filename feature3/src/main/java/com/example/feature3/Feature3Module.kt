package com.example.feature3

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Feature3Module {

    @ContributesAndroidInjector
    abstract fun feature3Fragment(): Feature3Fragment
}