package com.example.helpandhour.ui.screens.LogIn

sealed interface LoginEvent {
    data class useremailChanged (val email: String) : LoginEvent
    data class userpasswordChanged (val password: String) : LoginEvent
    data object LoginAttemp : LoginEvent
    data object createAccountRequest : LoginEvent
}