package com.example.bibliotecag_sdapp.ui.theme

import android.app.Activity
import androidx.compose.material3.windowsizeclass.*
import com.example.bibliotecag_sdapp.ui.theme.screens.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeScreen2() {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        WindowWidthSizeClass.Expanded -> HomeScreenExtendida()

    }
}


@Preview
@Composable
fun PreviewCompact(){
    HomeScreenExtendida()
}