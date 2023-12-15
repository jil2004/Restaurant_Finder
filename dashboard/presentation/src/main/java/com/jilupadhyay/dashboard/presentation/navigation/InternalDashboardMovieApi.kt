package com.jilupadhyay.dashboard.presentation.navigation

import com.jilupadhyay.common.utils.navigation.DashboardRoutes
import com.jilupadhyay.common.utils.navigation.FeatureApi
import com.jilupadhyay.common.utils.navigation.NestedNavigationRoute
import com.jilupadhyay.dashboard.presentation.screens.home.HomeScreen

object InternalDashboardMovieApi : FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = DashboardRoutes.HOME_SCREEN.route,route=NestedNavigationRoute.DASHBOARD.route){
            composable(route=DashboardRoutes.HOME_SCREEN.route) {
                HomeScreen()
            }
        }
    }
}