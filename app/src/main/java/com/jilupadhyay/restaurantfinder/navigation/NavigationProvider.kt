package com.jilupadhyay.restaurantfinder.navigation

import com.jilupadhyay.dashboard.presentation.navigation.DashboardApi
import com.jilupadhyay.location.presentation.navigation.LocationFeatureApi

data class NavigationProvider(
    val dashboardApi: DashboardApi,
    val locationFeatureApi: LocationFeatureApi
)
