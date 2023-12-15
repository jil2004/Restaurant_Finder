package com.jilupadhyay.location.data.repository

import android.health.connect.datatypes.ExerciseRoute
import android.location.LocationRequest
import android.renderscript.RenderScript
import android.renderscript.RenderScript.Priority
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.model.AutocompleteSessionToken
import com.google.android.libraries.places.api.model.LocationRestriction
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.jilupadhyay.common.utils.navigation.events_and_results.PlacesResult
import com.jilupadhyay.location.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import kotlin.reflect.KMutableProperty0

@Suppress("MissingPermission")
class LocationRepoImpl @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val placesClient: PlacesClient
): LocationRepository{

    private var currentLocation: LatLng = LatLng(0.0, 0.0)

    private val token = AutocompleteSessionToken.newInstance()

    override fun getLocationOnce(location: (ExerciseRoute.Location) -> Unit) {

        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 100).setIntervalMillis(1000)
            .setMaxUpdates(1).build()

        val locationCallback = object: LocationCallback(){
            override fun onLocationResult(p0: LocationResult) {
                p0.locations.get(0)?.let {
                    currentLocation = LatLng(it.lattitude, it.longitude)
                    location.invoke(it)
                }
            }
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null)


    }



    override fun searchRestaurants(q: String): Flow<PlacesResult> = callbackFlow{

        getLocationOnce { location ->

            val locationRestriction = findLocationRestriction(location)


            val request =
                FindAutocompletePredictionsRequest.builder()
                    .setSessionToken(token)
                    .setCountries(
                    mutableListOf("IN"))
                    .setQuery(q)
                    .setOrigin(LatLng(location.latitude,location.longitude))
                    .setTypesFilter(mutableListOf("restaurant"))
                    .setLocationRestriction(locationRestriction)
                    .build()

            placesClient.findAutocompletePredictions(request).addOnSuccessListener {
                trySend(PlacesResult.Success(location,it.autocompletePredictions))
            }.addOnFailureListener{
                trySend(PlacesResult.Error(it.message.toString()))
            }
        }
    }

    private fun findLocationRestriction(location: ExerciseRoute.Location): LocationRestriction {
        return RectangularBounds.newInstance(
            LatLng(location.latitude-0.9, location.longitude-0.9),
            LatLng(location.latitude+0.9, location.longitude+0.9),
        )

    }


}