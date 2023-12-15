package com.jilupadhyay.restaurantfinder.di

import com.jilupadhyay.common.utils.navigation.FeatureApi
import com.jilupadhyay.dashboard.presentation.navigation.DashboardApi
import com.jilupadhyay.location.presentation.navigation.LocationFeatureApi
import com.jilupadhyay.restaurantfinder.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(dashboardApi: DashboardApi, locationFeatureApi: LocationFeatureApi):NavigationProvider {
        return NavigationProvider(dashboardApi, locationFeatureApi)
    }

}