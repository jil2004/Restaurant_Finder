package com.jilupadhyay.restaurantfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jilupadhyay.restaurantfinder.navigation.MainNavigation
import com.jilupadhyay.restaurantfinder.navigation.NavigationProvider
import com.jilupadhyay.restaurantfinder.ui.theme.RestaurantFinderTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantFinderAppTheme {
                val navHostController = rememberNavController()
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                ) {
                    MainNavigation(navHostController = navHostController,
                                    navigationProvider = navigationProvider
                    )

                }

            }
        }
    }
}
