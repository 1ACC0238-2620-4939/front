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
fun VehicleListScreen(
    modifier: Modifier = Modifier,
    onCreateVehicle: () -> Unit = {},
    onVehicleSelected: (String) -> Unit = {}
) {
    var search by rememberSaveable { mutableStateOf("") }
    var selectedFilter by rememberSaveable { mutableStateOf("Todos") }

    val filters = listOf("Todos", "Activos", "Inactivos")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = onCreateVehicle) {
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
                text = "Vehículos",
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
                placeholder = { Text("Buscar por placa") },
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
                    items = sampleVehicles,
                    key = { it.id }
                ) { vehicle ->
                    VehiclePreviewCard(
                        vehicle = vehicle,
                        onClick = { onVehicleSelected(vehicle.id) }
                    )
                }
            }
        }
    }
}

private data class VehiclePreview(
    val id: String,
    val plateNumber: String,
    val capacity: String,
    val status: String
)

private val sampleVehicles = listOf(
    VehiclePreview(
        id = "1",
        plateNumber = "ABC-123",
        capacity = "5 000 kg",
        status = "Activo"
    ),
    VehiclePreview(
        id = "2",
        plateNumber = "DEF-456",
        capacity = "8 000 kg",
        status = "Activo"
    ),
    VehiclePreview(
        id = "3",
        plateNumber = "GHI-789",
        capacity = "3 000 kg",
        status = "Inactivo"
    )
)

@Composable
private fun VehiclePreviewCard(
    vehicle: VehiclePreview,
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = vehicle.plateNumber,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = vehicle.status,
                    style = MaterialTheme.typography.labelMedium,
                    color = if (vehicle.status == "Activo") {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }

            Text(
                text = "Capacidad de carga: ${vehicle.capacity}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}