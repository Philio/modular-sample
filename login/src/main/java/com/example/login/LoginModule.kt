package com.example.login

import com.example.api.ApiModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {

    @ContributesAndroidInjector(modules = [ApiModule::class])
    abstract fun loginActivity(): LoginActivity
}
