package com.example.modularsample

import com.example.main.MainModule
import dagger.Module

@Module(includes = [MainModule::class])
object FeatureModule