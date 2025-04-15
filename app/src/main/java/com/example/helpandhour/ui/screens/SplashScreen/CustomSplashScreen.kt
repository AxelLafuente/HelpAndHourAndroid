package com.example.helpandhour.ui.screens.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.helpandhour.R
import com.example.helpandhour.navigation.HomeRoute
import com.example.helpandhour.ui.theme.DefaultBackground
import com.example.helpandhour.ui.theme.LogoImgs
import kotlinx.coroutines.delay

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CustomSplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(HomeRoute) {
            popUpTo(0)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackground),
        contentAlignment = Alignment.Center
    ) {
        GlideImage(
            model = LogoImgs.LOGO_LIGHT,
            contentDescription = "Logo",
            modifier = Modifier.size(260.dp)
        )
    }
}