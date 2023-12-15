package com.jilupadhyay.location.presentation.navigation

import com.jilupadhyay.common.utils.navigation.FeatureApi
import com.jilupadhyay.common.utils.navigation.LocationRoutes
import com.jilupadhyay.common.utils.navigation.NestedNavigationRoute
import com.jilupadhyay.location.presentation.screens.google_maps.GoogleMapsScreen
import com.jilupadhyay.location.presentation.screens.places.RestaurantFinderScreen

object InternalLocationFeatureApi : FeatureApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = ,route=NestedNavigationRoute.LOCATION.route) {
            composable(route=LocationRoutes.PLACES_SEARCH.route) {
                RestaurantFinderScreen()
            }
            composable(route=LocationRoutes.GOOGLE_MAPS.route) {
                GoogleMapsScreen()
            }
        }
    }
}