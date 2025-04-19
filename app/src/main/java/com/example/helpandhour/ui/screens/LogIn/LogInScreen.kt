package com.example.helpandhour.ui.screens.LogIn

import DiamondDivider
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.helpandhour.navigation.CreateAccountRoute
import com.example.helpandhour.ui.UiEvent
import com.example.helpandhour.ui.components.CustomPositiveButton
import com.example.helpandhour.ui.components.CustomTextField
import com.example.helpandhour.ui.theme.DefaultBackground
import com.example.helpandhour.ui.theme.GrayText
import com.example.helpandhour.ui.theme.HelpAndHourTheme
import com.example.helpandhour.ui.theme.Jost
import com.example.helpandhour.ui.theme.LightComponentColor
import com.example.helpandhour.ui.theme.LogoImgs
import com.example.helpandhour.ui.theme.White

@Composable
fun LoginScreen(navController: NavHostController) {

    val viewModel = viewModel<LoginViewModel>(){
        LoginViewModel()
    }

    val email = viewModel.email
    val password = viewModel.password


    val snackbarHostState = remember {
        SnackbarHostState()
    }
    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.Navigate<*> -> {
                    when (uiEvent.route) {
                        is CreateAccountRoute -> navController.navigate(CreateAccountRoute)
                    }
                }

                UiEvent.NavigateBack -> TODO()

                is UiEvent.ShowSnackbar -> snackbarHostState.showSnackbar(
                    message = uiEvent.mesage,
                )
            }
        }
    }

            LoginContent(email, password, viewModel::onEvent, snackbarHostState)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun LoginContent(email: String,
                         password: String,
                         onEvent: (LoginEvent) -> Unit,
                         snackbarHostState: SnackbarHostState) {
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(DefaultBackground),
                contentAlignment = Alignment.Center
            )
            {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .shadow(6.dp, RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = LightComponentColor)
                ) {

                    GlideImage(
                        model = LogoImgs.LOGO_DEFAULT,
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(bottom = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Login",
                        color = White,
                        style = TextStyle(
                            fontFamily = Jost,
                            fontWeight = FontWeight.Normal,
                            fontSize = 24.sp
                        )

                    )

                    DiamondDivider(horizontalPadding = 36.dp)

                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        CustomTextField(
                            placeholder = "Email",
                            modifier = Modifier,
                            value = email,
                            onValueChange = {onEvent(LoginEvent.useremailChanged(it))},
                            keyboardType = KeyboardType.Email
                        )
                        Spacer(modifier = Modifier.size(28.dp))

                        CustomTextField(
                            placeholder = "Senha",
                            modifier = Modifier,
                            value = password,
                            onValueChange = {onEvent(LoginEvent.userpasswordChanged(it))},
                            textFieldTransformation = PasswordVisualTransformation(),
                            keyboardType = KeyboardType.Password,
                            autocorrect = false
                        )
                        Text(
                            modifier = Modifier.align(Alignment.Start),
                            text = "Esqueci minha senha",
                            color = GrayText,
                            style = TextStyle(
                                fontFamily = Jost,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                        Spacer(modifier = Modifier.size(52.dp))

                        CustomPositiveButton(
                            modifier = Modifier,
                            text = "Entrar",
                            onClick = {onEvent(LoginEvent.LoginAttemp)},
                            height = 50,
                            width = 200
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                .clickable { onEvent(LoginEvent.Navigate) },
                            text = "Não possui conta? Cadastre-se",
                            color = GrayText,
                            style = TextStyle(
                                fontFamily = Jost,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                        Spacer(modifier = Modifier.size(42.dp))
                    }
                }

            }

        })
}

@Preview
@Composable
private fun LogInContentPreview() {
    HelpAndHourTheme {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        val viewModel = viewModel<LoginViewModel>(){
            LoginViewModel()
        }


        val snackbarHostState = remember {
            SnackbarHostState()
        }
        LoginContent(email, password, viewModel::onEvent, snackbarHostState)
    }
}