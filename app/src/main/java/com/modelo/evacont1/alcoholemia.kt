package com.modelo.evacont1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun calcularAlcohol() {
    var vehicleType by remember { mutableStateOf("") }
    var alcoholLevel by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = vehicleType,
            onValueChange = { vehicleType = it },
            label = { Text("Tipo de vehículo (C, A, T, M)") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* No action */ })
        )

        OutlinedTextField(
            value = alcoholLevel,
            onValueChange = { alcoholLevel = it },
            label = { Text("Tasa de alcohol") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* No action */ })
        )

        Button(
            onClick = {
                result = Alcoholemia().verificarTasa(vehicleType, alcoholLevel.toDoubleOrNull() ?: 0.0)
            },
            enabled = vehicleType.isNotBlank() && alcoholLevel.isNotBlank()
        ) {
            Text("Verificar")
        }

        Text(text = result)
    }
}

class Alcoholemia {
    fun verificarTasa(tipoVehiculo: String, tasaAlcohol: Double): String {
        val maxTasa = when (tipoVehiculo.uppercase()) {
            "C", "A", "M" -> 0.3
            "T" -> 0.5
            else -> return "Tipo de vehículo no válido."
        }

        return if (tasaAlcohol > maxTasa) {
            "Positivo en control de alcoholemia."
        } else {
            "Negativo en control de alcoholemia."
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalcularAlcoholPreview() {
    calcularAlcohol()
}