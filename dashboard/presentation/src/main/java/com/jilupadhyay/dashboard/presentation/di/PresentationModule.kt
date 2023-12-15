package com.jilupadhyay.dashboard.presentation.di

import com.jilupadhyay.dashboard.presentation.navigation.DashboardApi
import com.jilupadhyay.dashboard.presentation.navigation.DashboardApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PresentationModule {

    @Provides
    fun provideDashBoardApi():DashboardApi{
        return DashboardApiImpl()
    }
}