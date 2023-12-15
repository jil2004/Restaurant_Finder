package com.jilupadhyay.restaurantfinder.navigation

import androidx.compose.runtime.Composable
import com.jilupadhyay.common.utils.navigation.NestedNavigationRoute

@Composable
fun MainNavigation(navHostController: NavHostController, navigationProvider: NavigationProvider) {

    NavHost(navController = navHostController, startDestination = NestedNavigationRoute.DASHBOARD.route ) {
        navigationProvider.dashboardApi.registerGraph(navHostController, this)
        navigationProvider.locationFeatureApi.registerGraph(navHostController, this)
    }
}