package com.jilupadhyay.dashboard.presentation.navigation

import com.jilupadhyay.common.utils.navigation.FeatureApi

interface DashboardApi : FeatureApi {

}

class DashboardApiImpl : DashboardApi {
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        InternalDashboardMovieApi.registerGraph(navHostController, navGraphBuilder)
    }
}