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
fun OperarNumeros() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Ingrese el primer número") }
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Ingrese el segundo número") }
        )

        Button(
            onClick = {
                val n1 = num1.toDoubleOrNull() ?: 0.0
                val n2 = num2.toDoubleOrNull() ?: 0.0
                result = when {
                    n1 == n2 -> "Resultado: ${n1 * n2}"
                    n1 > n2 -> "Resultado: ${n1 - n2}"
                    else -> "Resultado: ${n1 + n2}"
                }
            },
            enabled = num1.isNotBlank() && num2.isNotBlank()
        ) {
            Text("Calcular")
        }

        Text(text = result)
    }
}

@Preview(showBackground = true)
@Composable
fun OperarNumerosPreview() {
    OperarNumeros()
}