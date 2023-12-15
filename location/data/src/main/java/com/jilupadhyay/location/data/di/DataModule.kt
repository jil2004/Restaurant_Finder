package com.jilupadhyay.location.data.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import com.jilupadhyay.location.data.repository.LocationRepoImpl
import com.jilupadhyay.location.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideFusedLocationProviderClient(@ApplicationContext context: Context):FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(context)
    }

    @Singleton
    @Provides
    fun providePlacesClient(@ApplicationContext context: Context): PlacesClient {
        Places.initialize(context, "")
        return Places.createClient(context)
    }

    @Provides
    fun provideLocationRepo(fusedLocationProviderClient: FusedLocationProviderClient, placesClient: PlacesClient):LocationRepository{
        return LocationRepoImpl(fusedLocationProviderClient, placesClient)
    }

}