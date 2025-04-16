package com.example.helpandhour.ui.screens.LogIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpandhour.ui.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set


    private val _uiEvent = Channel<UiEvent>()
    val uiEvent  = _uiEvent.receiveAsFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.useremailChanged -> {
                email = event.email
            }

            is LoginEvent.userpasswordChanged -> {
                password = event.password
            }

            LoginEvent.LoginAttemp -> {
                viewModelScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        _uiEvent.send(UiEvent.ShowSnackbar("Email ou senha vazios"))
                        return@launch
                    }
                    else{
                        _uiEvent.send(UiEvent.ShowSnackbar("Logado"))
                        return@launch
                    }
                }
            }
        }
    }


}