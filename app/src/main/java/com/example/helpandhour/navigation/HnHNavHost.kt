package com.example.helpandhour.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helpandhour.ui.screens.SplashScreen.CustomSplashScreen
import com.example.helpandhour.ui.screens.Home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object SplashRoute

@Composable
fun HnHNavHost(){
    val navController = rememberNavController()
        NavHost(navController = navController, startDestination = SplashRoute){
            composable<SplashRoute>{
                CustomSplashScreen(navController)
            }
            composable<HomeRoute>{
                HomeScreen(navController)

        }

    }
}