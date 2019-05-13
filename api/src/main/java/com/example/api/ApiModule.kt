package com.example.api

import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object ApiModule {

    // A real repository would have dependencies, e.g. Retrofit
    @Provides @Reusable @JvmStatic
    fun provideApiRepository() = ApiRepository()
}
