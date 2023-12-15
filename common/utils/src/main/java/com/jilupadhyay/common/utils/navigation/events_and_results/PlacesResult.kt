package com.jilupadhyay.common.utils.navigation.events_and_results

import android.health.connect.datatypes.ExerciseRoute
import android.widget.AutoCompleteTextView
import com.google.android.libraries.places.api.model.AutocompletePrediction

sealed class PlacesResult (
    val location: ExerciseRoute.Location?=null,
    val list:MutableList<AutocompletePrediction> = mutableListOf(),
    val message:String?=null
)   {

    class Success(location: Location, list:MutableList<AutocompletePrediction>) : PlacesResult(location, list)

    class Loading():PlacesResult()

    class Idle():PlacesResult

    class Error(message:String) : PlacesResult(message = message)

}