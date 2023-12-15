package com.jilupadhyay.common.utils.navigation

import androidx.navigation.NavHostController

interface FeatureApi {

    fun registerGraph(navHostController:NavHostController,navGraphBuilder: NavGraphBuilder)

}