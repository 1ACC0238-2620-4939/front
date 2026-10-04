package com.trakto.traktoroute.shared.presentation.ui.components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun AddFloatingActionButton(
    onClick: () -> Unit,
    description: String,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier.semantics {
            contentDescription = description
        }
    ) {
        Text(
            text = "+",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}