package com.trakto.traktoroute.shared.presentation.navigation

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.trakto.traktoroute.fleet.presentation.ui.screens.DriverListScreen
import com.trakto.traktoroute.fleet.presentation.ui.screens.VehicleListScreen
import com.trakto.traktoroute.profiles.presentation.ui.screens.ProfileScreen
import com.trakto.traktoroute.shared.presentation.ui.layout.AppScaffold
import com.trakto.traktoroute.trip.presentation.ui.screens.TripListScreen
import com.trakto.traktoroute.shared.presentation.ui.components.AddFloatingActionButton

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val destination = backStackEntry?.destination

    val selectedTab = when {
        destination?.hasRoute<VehiclesRoute>() == true -> AppTab.VEHICLES
        destination?.hasRoute<DriversRoute>() == true -> AppTab.DRIVERS
        destination?.hasRoute<ProfileRoute>() == true -> AppTab.PROFILE
        else -> AppTab.TRIPS
    }

    AppScaffold(
        modifier = modifier,
        selectedTab = selectedTab,
        onTabSelected = { tab ->
            val route = when (tab) {
                AppTab.TRIPS -> TripsRoute
                AppTab.VEHICLES -> VehiclesRoute
                AppTab.DRIVERS -> DriversRoute
                AppTab.PROFILE -> ProfileRoute
            }

            navController.navigate(route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        floatingActionButton = {
            if (selectedTab != AppTab.PROFILE) {
                val description = when (selectedTab) {
                    AppTab.TRIPS -> "Agregar viaje"
                    AppTab.VEHICLES -> "Agregar vehículo"
                    AppTab.DRIVERS -> "Agregar conductor"
                    AppTab.PROFILE -> ""
                }

                AddFloatingActionButton(
                    description = description,
                    onClick = {
                        // Conectaremos la navegación de creación después.
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TripsRoute,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        ) {
            composable<TripsRoute> {
                TripListScreen()
            }

            composable<VehiclesRoute> {
                VehicleListScreen()
            }

            composable<DriversRoute> {
                DriverListScreen()
            }

            composable<ProfileRoute> {
                ProfileScreen()
            }
        }
    }
}