package com.example.helpandhour.ui.screens.CreateAccount

import DiamondDivider
import android.widget.CheckBox
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helpandhour.ui.components.CustomTextField
import com.example.helpandhour.ui.theme.DefaultBackground
import com.example.helpandhour.ui.theme.DefaultComponentColor
import com.example.helpandhour.ui.theme.Jost
import com.example.helpandhour.ui.theme.LightComponentColor
import com.example.helpandhour.ui.theme.White


@Composable
fun CreateAccountScreen() {

    CreateAccountContent()

}


@Composable
fun CreateAccountContent() {

    var scrollState = rememberScrollState()
    Scaffold(
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
                        style = TextStyle( fontSize = 24.sp,
                            fontFamily = Jost,
                            color = White
                        )
                    )
                    DiamondDivider(horizontalPadding = 48.dp, modifier = Modifier.padding(bottom = 40.dp))

                    CustomTextField(
                        placeholder = "Nome Completo*",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Endereço*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Numero",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "CEP",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Telefone*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Email*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Instituição de ensino*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Data de Nascimento*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Senha*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    CustomTextField(
                        placeholder = "Confirmar senha*",
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        value = "",
                        onValueChange = {}
                    )
                    Checkbox(modifier = Modifier.padding(vertical = 24.dp), checked = false, onCheckedChange = {})

                }

            }
        })

}

@Preview
@Composable
private fun CreateAccountContentPreview() {
    CreateAccountContent()
}
