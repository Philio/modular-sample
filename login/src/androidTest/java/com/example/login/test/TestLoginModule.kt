package com.example.login.test

import com.example.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestLoginModule {

    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity
}
