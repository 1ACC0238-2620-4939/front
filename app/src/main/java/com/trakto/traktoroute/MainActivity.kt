package com.trakto.traktoroute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.trakto.traktoroute.shared.presentation.navigation.AppNavHost
import com.trakto.traktoroute.shared.presentation.ui.theme.TraktoRouteTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TraktoRouteTheme {
                AppNavHost()
            }
        }
    }
}