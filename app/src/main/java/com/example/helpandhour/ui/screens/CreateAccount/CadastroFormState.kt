package com.example.helpandhour.ui.screens.CreateAccount

data class CadastroFormState(
    val nome: String = "",
    val email: String = "",
    val telefone: String = "",
    val endereco: String = "",
    val ensino: String = "",
    val numero: String = "",
    val cep: String = "",
    val nascimento: String = "",
    val senha: String = "",
    val confirmarSenha: String = ""
)