package com.example.helpandhour.ui.screens.CreateAccount

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpandhour.ui.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CadastroViewModel() : ViewModel() {
    var formState by mutableStateOf(CadastroFormState())
        private set

    var checked by mutableStateOf(false)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent  = _uiEvent.receiveAsFlow()


    fun onEvent(event: CadastroEvent) {
        when (event) {
            is CadastroEvent.OnFieldChanged -> {
                formState = when (event.field) {
                    "nome" -> formState.copy(nome = event.value)
                    "email" -> formState.copy(email = event.value)
                    "senha" -> formState.copy(senha = event.value)
                    "confirmarSenha" -> formState.copy(confirmarSenha = event.value)
                    "cep" -> formState.copy(cep = event.value)
                    "telefone" -> formState.copy(telefone = event.value)
                    "endereco" -> formState.copy(endereco = event.value)
                    "numero" -> formState.copy(numero = event.value)
                    "ensino" -> formState.copy(ensino = event.value)
                    "nascimento" -> formState.copy(nascimento = event.value)
                    else -> formState
                }
            }
            is CadastroEvent.OnCheckedChange -> {
                checked = event.value
            }

            CadastroEvent.Submit -> {
                viewModelScope.launch {
                    if (!isFormValid()) {
                        _uiEvent.send(UiEvent.ShowSnackbar("Existem campos não preenchidos."))
                        return@launch
                    }
                    _uiEvent.send(UiEvent.ShowSnackbar("Cadastro realizado com sucesso!"))
                        return@launch
                }
            }
        }
    }

    private fun isFormValid(): Boolean {
        return with(formState) {
            nome.isNotBlank() &&
                    email.isNotBlank() &&
                    senha.isNotBlank() &&
                    confirmarSenha.isNotBlank() &&
                    cep.isNotBlank() &&
                    telefone.isNotBlank() &&
                    endereco.isNotBlank() &&
                    numero.isNotBlank() &&
                    ensino.isNotBlank() &&
                    nascimento.isNotBlank()
        }
    }
}