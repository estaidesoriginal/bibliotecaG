package com.example.bibliotecag_sdapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bibliotecag_sdapp.ui.theme.BibliotecaG_SDappTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import android.util.Patterns


// -------------------------------------------------------------------------
// 1. EL COMPONENTE ACTIVITY (Punto de entrada)
// -------------------------------------------------------------------------

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaG_SDappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BibliotecaG_SDappTheme {
        SimpleTextField()
    }
}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") }
    )
}

// -------------------------------------------------------------------------
// 2. EL COMPONENTE INTELIGENTE (Dueño del estado y la lógica)
// -------------------------------------------------------------------------

@Composable
fun FormularioScreen() {
    // Definición de los estados del formulario usando destructuring 'by'
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") } // Mensaje de validación/éxito

    // La lógica de validación y envío
    val onEnviarClick: () -> Unit = {
        if (nombre.isBlank() || email.isBlank()) {
            mensaje = "🚫 Por favor, completa todos los campos."
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mensaje = "❌ Formato de correo electrónico inválido."
        } else {
            // Lógica de envío exitoso (aquí iría la llamada a la API o ViewModel)
            mensaje = "✅ Datos enviados con éxito:\nNombre: $nombre\nEmail: $email"
        }
    }

    // Llama al componente de presentación (la UI)
    FormularioUI(
        nombre = nombre,
        onNombreChange = { nombre = it }, // Función para actualizar el estado del nombre
        email = email,
        onEmailChange = { email = it },   // Función para actualizar el estado del email
        onEnviarClick = onEnviarClick,
        mensaje = mensaje
    )
}

// -------------------------------------------------------------------------
// 3. EL COMPONENTE DE PRESENTACIÓN (La interfaz de usuario "muda")
// -------------------------------------------------------------------------


//Componente UI que solo recibe datos y notifica eventos (Flujo Unidireccional).

@Composable
fun FormularioUI(
    nombre: String,
    onNombreChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    onEnviarClick: () -> Unit,
    mensaje: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de Usuario",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo para el Nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = onNombreChange,
            label = { Text("Nombre Completo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Campo para el Email
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Correo Electrónico") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            singleLine = true
        )

        // Botón de Enviar
        Button(
            onClick = onEnviarClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Registrarse")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Mensaje de resultado o validación
        if (mensaje.isNotEmpty()) {
            val color = when {
                mensaje.startsWith("✅") -> Color(0xFF006400) // Verde oscuro para éxito
                mensaje.startsWith("🚫") || mensaje.startsWith("❌") -> Color.Red
                else -> Color.Black
            }
            Text(
                text = mensaje,
                color = color,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

// -------------------------------------------------------------------------
// 4. PREVIEW (Para ver el diseño sin ejecutar la app)
// -------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun FormularioPreview() {

    BibliotecaG_SDappTheme {
        FormularioUI(
            nombre = "Juan Pérez",
            onNombreChange = {},
            email = "juan@ejemplo.com",
            onEmailChange = {},
            onEnviarClick = {},
            mensaje = "Esto es un mensaje de prueba para el Preview."
        )
    }
}

