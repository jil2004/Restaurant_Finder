package com.jilupadhyay.location.domain.repository

import android.health.connect.datatypes.ExerciseRoute
import com.jilupadhyay.common.utils.navigation.events_and_results.PlacesResult
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getLocationOnce(location:(ExerciseRoute.Location)->Unit)

    fun searchRestaurants(q:String): Flow<PlacesResult>
}