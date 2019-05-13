package com.example.modularsample

import android.app.Application
import com.example.api.ApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, FeatureModule::class, ApiModule::class])
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }
}
