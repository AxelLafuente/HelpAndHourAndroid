package com.example.helpandhour.ui.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.helpandhour.ui.theme.DefaultBackground

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackground),
        contentAlignment = Alignment.Center
    ) {
        Text("Bem-vindo ao App!", fontSize = 24.sp)
    }
}