package com.trakto.traktoroute.trip.presentation.ui.screens

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TripListScreen(
    modifier: Modifier = Modifier,
    onTripSelected: (String) -> Unit = {}
) {
    var search by rememberSaveable { mutableStateOf("") }
    var selectedFilter by rememberSaveable { mutableStateOf("Todos") }

    val filters = listOf(
        "Todos",
        "Programados",
        "En curso",
        "Finalizados",
        "Cancelados"
    )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Viajes",
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
            placeholder = { Text("Buscar viaje") },
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
                items = sampleTrips,
                key = { it.id }
            ) { trip ->
                TripPreviewCard(
                    trip = trip,
                    onClick = { onTripSelected(trip.id) }
                )
            }
        }
    }
}

// Datos visuales de ejemplo.
private data class TripPreview(
    val id: String,
    val origin: String,
    val destination: String,
    val driver: String,
    val vehicle: String,
    val scheduledAt: String,
    val status: String
)

private val sampleTrips = listOf(
    TripPreview(
        id = "1",
        origin = "Santa Anita",
        destination = "Miraflores",
        driver = "Carlos Mendoza",
        vehicle = "ABC-123",
        scheduledAt = "04 oct. · 08:00",
        status = "Programado"
    ),
    TripPreview(
        id = "2",
        origin = "Callao",
        destination = "San Isidro",
        driver = "Ana Torres",
        vehicle = "DEF-456",
        scheduledAt = "03 oct. · 15:30",
        status = "En curso"
    ),
    TripPreview(
        id = "3",
        origin = "Lurín",
        destination = "Ate",
        driver = "Luis García",
        vehicle = "BAN-322",
        scheduledAt = "03 oct. · 09:00",
        status = "Finalizado"
    ),
    TripPreview(
        id = "4",
        origin = "Asia",
        destination = "Miraflores",
        driver = "Luis García",
        vehicle = "DUV-269",
        scheduledAt = "06 oct. · 06:00",
        status = "Finalizado"
    ),
    TripPreview(
        id = "5",
        origin = "Ate",
        destination = "Lurín",
        driver = "Pepe Lucho",
        vehicle = "QUE-322",
        scheduledAt = "07 oct. · 10:00",
        status = "Finalizado"
    )
)

@Composable
private fun TripPreviewCard(
    trip: TripPreview,
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
                    text = "Viaje #${trip.id}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = trip.status,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = "${trip.origin} → ${trip.destination}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Conductor: ${trip.driver}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Vehículo: ${trip.vehicle}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = trip.scheduledAt,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}