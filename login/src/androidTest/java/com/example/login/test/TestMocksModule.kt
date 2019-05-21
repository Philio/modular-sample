package com.example.login.test

import com.example.api.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.mockk.mockk

@Module
class TestMocksModule(private val apiRepository: ApiRepository = mockk()) {

    @Provides @Reusable
    fun provideApiRepository() = apiRepository
}