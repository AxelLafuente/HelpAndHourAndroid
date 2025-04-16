package com.example.helpandhour.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.draw.shadow
import com.example.helpandhour.ui.theme.Black
import com.example.helpandhour.ui.theme.UnfocusedText
import com.example.helpandhour.ui.theme.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.helpandhour.ui.theme.Jost


@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Input",
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textFieldTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    autocorrect: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, style = TextStyle(
            fontFamily = Jost,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ))},
        singleLine = true,
        visualTransformation = textFieldTransformation,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(vertical = 4.dp)
            .shadow( 6.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = White,
            disabledBorderColor = White,
            focusedTextColor = Black,
            unfocusedTextColor = UnfocusedText,
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            disabledPlaceholderColor = UnfocusedText
        ),
        textStyle = TextStyle(
            fontFamily = Jost,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        enabled = isEnabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            autoCorrect = autocorrect
        ),
    )
}



@Preview
@Composable
private fun CustomTextFieldPreview() {
    CustomTextField(
        value = "",
        onValueChange = {},
        placeholder = "Input")
}