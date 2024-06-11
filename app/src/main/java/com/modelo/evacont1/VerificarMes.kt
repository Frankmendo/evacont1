package com.modelo.evacont1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VerificarMes() {
    var numero by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = numero,
            onValueChange = { numero = it },
            label = { Text("Ingrese un número (1-12)") }
        )

        Button(
            onClick = {
                mes = obtenerMes(numero.toIntOrNull() ?: 0)
            },
            enabled = numero.isNotBlank()
        ) {
            Text("Verificar")
        }

        Text(text = mes)
    }
}

fun obtenerMes(numero: Int): String {
    return when (numero) {
        1 -> "Enero"
        2 -> "Febrero"
        3 -> "Marzo"
        4 -> "Abril"
        5 -> "Mayo"
        6 -> "Junio"
        7 -> "Julio"
        8 -> "Agosto"
        9 -> "Septiembre"
        10 -> "Octubre"
        11 -> "Noviembre"
        12 -> "Diciembre"
        else -> "Número no válido"
    }
}

@Preview(showBackground = true)
@Composable
fun VerificarMesPreview() {
    VerificarMes()
}