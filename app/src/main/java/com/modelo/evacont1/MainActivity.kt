package com.modelo.evacont1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.modelo.evacont1.ui.theme.Evacont1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Evacont1Theme {
                calcularAlcohol()
                //OperarNumeros()
                //VerificarMes()
                //ImprimirSuma()


            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Evacont1Theme {
    }
}