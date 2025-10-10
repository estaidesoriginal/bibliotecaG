package com.example.bibliotecag_sdapp.ui.theme

import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.ui.tooling.preview.Preview
import com.example.bibliotecag_sdapp.ui.theme.screens.HomeScreenCompacta

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun obtenerWindowSizeClass(): WindowSizeClass {
     val context = LocalContext.current
     return calculateWindowSizeClass(context as ComponentActivity)
}



