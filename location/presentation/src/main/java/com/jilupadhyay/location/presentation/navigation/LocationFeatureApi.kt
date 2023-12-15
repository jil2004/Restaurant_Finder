package com.jilupadhyay.location.presentation.navigation

import com.jilupadhyay.common.utils.navigation.FeatureApi

interface LocationFeatureApi : FeatureApi{

}

class LocationFeatureApiImpl: LocationFeatureApi{
    override fun registerGraph(
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        InternalLocationFeatureApi.registerGraph(navHostController, navGraphBuilder)
    }
}