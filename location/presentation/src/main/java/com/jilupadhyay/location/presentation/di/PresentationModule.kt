package com.jilupadhyay.location.presentation.di

import com.jilupadhyay.location.presentation.navigation.LocationFeatureApi
import com.jilupadhyay.location.presentation.navigation.LocationFeatureApiImpl

@InstallIn(SingletonComponent::class)
@Module
object PresentationModule {

    @Provides
    fun provideLocationFeatureApi():LocationFeatureApi{
        return LocationFeatureApiImpl()
    }
}