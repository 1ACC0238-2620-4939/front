package com.trakto.traktoroute.fleet.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DriverListScreen(
    modifier: Modifier = Modifier,
    onCreateDriver: () -> Unit = {},
    onDriverSelected: (String) -> Unit = {}
) {
    var search by rememberSaveable { mutableStateOf("") }
    var selectedFilter by rememberSaveable { mutableStateOf("Todos") }

    val filters = listOf(
        "Todos",
        "Disponibles",
        "No disponibles",
        "Inactivos"
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = onCreateDriver) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Conductores",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp
                )
            )

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = { Text("Buscar por nombre o licencia") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filters) { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) }
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 96.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = sampleDrivers,
                    key = { it.id }
                ) { driver ->
                    DriverPreviewCard(
                        driver = driver,
                        onClick = { onDriverSelected(driver.id) }
                    )
                }
            }
        }
    }
}

// Datos visuales provisionales.
private data class DriverPreview(
    val id: String,
    val name: String,
    val licenseNumber: String,
    val status: String
)

private val sampleDrivers = listOf(
    DriverPreview(
        id = "1",
        name = "Carlos Mendoza",
        licenseNumber = "Q12345678",
        status = "Disponible"
    ),
    DriverPreview(
        id = "2",
        name = "Ana Torres",
        licenseNumber = "Q23456789",
        status = "No disponible"
    ),
    DriverPreview(
        id = "3",
        name = "Luis García",
        licenseNumber = "Q34567890",
        status = "Inactivo"
    )
)

@Composable
private fun DriverPreviewCard(
    driver: DriverPreview,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = driver.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = driver.status,
                    style = MaterialTheme.typography.labelMedium,
                    color = if (driver.status == "Disponible") {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }

            Text(
                text = "Licencia: ${driver.licenseNumber}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}