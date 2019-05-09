package com.example.modularsample

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, FeatureModule::class])
interface AppComponent : AndroidInjector<MyApp>