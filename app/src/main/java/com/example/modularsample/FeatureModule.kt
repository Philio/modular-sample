package com.example.modularsample

import com.example.login.LoginModule
import com.example.main.MainModule
import dagger.Module

@Module(includes = [LoginModule::class, MainModule::class])
object FeatureModule
