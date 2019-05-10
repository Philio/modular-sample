package com.example.modularsample

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, FeatureModule::class])
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
