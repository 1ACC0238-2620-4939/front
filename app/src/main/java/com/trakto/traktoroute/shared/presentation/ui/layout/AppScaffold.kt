package com.trakto.traktoroute.shared.presentation.ui.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.trakto.traktoroute.shared.presentation.ui.components.AppBottomBar
import com.trakto.traktoroute.shared.presentation.navigation.AppTab

@Composable
fun AppScaffold(
    selectedTab: AppTab,
    onTabSelected: (AppTab) -> Unit,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                AppBottomBar(
                    selectedTab = selectedTab,
                    onTabSelected = onTabSelected
                )
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}