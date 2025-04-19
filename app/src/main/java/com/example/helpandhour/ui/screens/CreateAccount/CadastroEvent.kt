package com.example.helpandhour.ui.screens.CreateAccount

sealed interface CadastroEvent {
    data class OnFieldChanged(val field: String, val value: String) : CadastroEvent
    data object Submit : CadastroEvent
}