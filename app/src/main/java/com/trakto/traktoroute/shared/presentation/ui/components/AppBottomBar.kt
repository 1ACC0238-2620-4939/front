package com.trakto.traktoroute.shared.presentation.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.trakto.traktoroute.shared.presentation.ui.icons.DirectionsCar
import com.trakto.traktoroute.shared.presentation.ui.icons.FactCheck
import com.trakto.traktoroute.shared.presentation.ui.icons.Person

enum class AppTab {
    TRIPS,
    VEHICLES,
    DRIVERS
}

@Composable
fun AppBottomBar(
    selectedTab: AppTab,
    onTabSelected: (AppTab) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = selectedTab == AppTab.TRIPS,
            onClick = { onTabSelected(AppTab.TRIPS) },
            icon = {
                Icon(
                    imageVector = FactCheck,
                    contentDescription = null
                )
            },
            label = { Text("Viajes") }
        )

        NavigationBarItem(
            selected = selectedTab == AppTab.VEHICLES,
            onClick = { onTabSelected(AppTab.VEHICLES) },
            icon = {
                Icon(
                    imageVector = DirectionsCar,
                    contentDescription = null
                )
            },
            label = { Text("Vehículos") }
        )

        NavigationBarItem(
            selected = selectedTab == AppTab.DRIVERS,
            onClick = { onTabSelected(AppTab.DRIVERS) },
            icon = {
                Icon(
                    imageVector = Person,
                    contentDescription = null
                )
            },
            label = { Text("Conductores") }
        )
    }
}