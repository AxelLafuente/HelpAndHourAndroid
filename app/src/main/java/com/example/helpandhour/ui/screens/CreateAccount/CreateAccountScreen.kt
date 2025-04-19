package com.example.helpandhour.ui.screens.CreateAccount

import DiamondDivider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.helpandhour.ui.UiEvent
import com.example.helpandhour.ui.components.CustomPositiveButton
import com.example.helpandhour.ui.components.CustomTextField
import com.example.helpandhour.ui.theme.DefaultBackground
import com.example.helpandhour.ui.theme.Jost
import com.example.helpandhour.ui.theme.LightComponentColor
import com.example.helpandhour.ui.theme.PositiveButtonColor
import com.example.helpandhour.ui.theme.White


@Composable
fun CreateAccountScreen() {

    val viewModel = viewModel<CadastroViewModel> {
        CadastroViewModel()
    }

    val cadastroForm = viewModel.formState

    val checked = viewModel.checked

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.Navigate<*> -> TODO()

                UiEvent.NavigateBack -> TODO()

                is UiEvent.ShowSnackbar -> snackbarHostState.showSnackbar(
                    message = uiEvent.mesage,
                )
            }
        }
    }

    CreateAccountContent(cadastroForm, viewModel::onEvent, snackbarHostState, checked)

}


@Composable
fun CreateAccountContent(
    cadastroForm: CadastroFormState,
    onEvent: (CadastroEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    checked: Boolean
) {

    var scrollState = rememberScrollState()
    Scaffold( snackbarHost ={ SnackbarHost(snackbarHostState)},
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(DefaultBackground)
                    .verticalScroll(scrollState),
                contentAlignment = Alignment.Center
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(vertical = 36.dp)
                        .shadow(6.dp, RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = LightComponentColor)
                )
                {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp),
                        text = "Cadastrar",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = Jost,
                            color = White
                        )
                    )
                    DiamondDivider(
                        horizontalPadding = 48.dp,
                        modifier = Modifier.padding(bottom = 40.dp)
                    )

                    CustomTextField(
                        placeholder = "Nome Completo*",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                        value = cadastroForm.nome,
                        onValueChange = { onEvent(CadastroEvent.OnFieldChanged("nome", it)) }
                    )
                    CustomTextField(
                        placeholder = "Endereço*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.endereco,
                        onValueChange = { onEvent(CadastroEvent.OnFieldChanged("endereco", it)) }
                    )
                    CustomTextField(
                        placeholder = "Numero*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.numero,
                        onValueChange = { onEvent(CadastroEvent.OnFieldChanged("numero", it)) }
                    )

                    CustomTextField(
                        placeholder = "CEP*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.cep,
                        onValueChange = {onEvent(CadastroEvent.OnFieldChanged("cep", it))}
                    )
                    CustomTextField(
                        placeholder = "Telefone*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.telefone,
                        onValueChange = {onEvent(CadastroEvent.OnFieldChanged("telefone", it))}
                    )
                    CustomTextField(
                        placeholder = "Email*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.email,
                        onValueChange = {onEvent(CadastroEvent.OnFieldChanged("email", it))}
                    )
                    CustomTextField(
                        placeholder = "Instituição de ensino*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.ensino,
                        onValueChange = {onEvent.invoke(CadastroEvent.OnFieldChanged("ensino", it))}
                    )
                    CustomTextField(
                        placeholder = "Data de Nascimento*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.nascimento,
                        onValueChange = {onEvent(CadastroEvent.OnFieldChanged("nascimento", it))}
                    )
                    CustomTextField(
                        placeholder = "Senha*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.senha,
                        onValueChange = {onEvent(CadastroEvent.OnFieldChanged("senha", it))}
                    )
                    CustomTextField(
                        placeholder = "Confirmar senha*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = cadastroForm.confirmarSenha,
                        onValueChange = {onEvent(CadastroEvent.OnFieldChanged("confirmarSenha", it))}
                    )

                    Checkbox(
                        modifier = Modifier.padding(vertical = 24.dp, horizontal = 12.dp),
                        checked = checked,
                        onCheckedChange = { onEvent.invoke(CadastroEvent.OnCheckedChange(it)) },
                        colors = CheckboxColors(
                            checkedCheckmarkColor = PositiveButtonColor,
                            uncheckedCheckmarkColor = White,
                            checkedBoxColor = PositiveButtonColor,
                            uncheckedBoxColor = White,
                            disabledCheckedBoxColor = White,
                            disabledUncheckedBoxColor = White,
                            disabledIndeterminateBoxColor = White,
                            checkedBorderColor = PositiveButtonColor,
                            uncheckedBorderColor = White,
                            disabledBorderColor = White,
                            disabledUncheckedBorderColor = White,
                            disabledIndeterminateBorderColor = White,
                        )
                    )

                    CustomPositiveButton(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(vertical = 24.dp),
                        text = "Cadastrar-se",
                        onClick = { onEvent(CadastroEvent.Submit) })
                }

            }
        })

}

@Preview
@Composable
private fun CreateAccountContentPreview() {

    val viewModel = viewModel<CadastroViewModel> {
        CadastroViewModel()
    }

    val cadastroForm = viewModel.formState

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val checked = viewModel.checked

    CreateAccountContent(cadastroForm, viewModel::onEvent, snackbarHostState, checked)
}

