package com.modelo.evacont1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ImprimirSuma() {
    var resultados by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Hacer que la columna sea desplazable
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado uniforme
    ) {
        Spacer(modifier = Modifier.height(32.dp))  // Añadir un espacio en la parte superior

        Button(
            onClick = {
                resultados = obtenerSumaDigitos()
            },
            modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.CenterHorizontally)
        ) {
            Text("Calcular Suma de Dígitos")
        }

        Text(text = resultados)
    }
}

fun obtenerSumaDigitos(): String {
    val resultados = StringBuilder()
    for (numero in 23..99) {
        val suma = numero.toString().map { it.toString().toInt() }.sum()
        resultados.append("Número: $numero, Suma de dígitos: $suma\n")
    }
    return resultados.toString()
}

@Preview(showBackground = true)
@Composable
fun ImprimirSumaPreview() {
    ImprimirSuma()
}