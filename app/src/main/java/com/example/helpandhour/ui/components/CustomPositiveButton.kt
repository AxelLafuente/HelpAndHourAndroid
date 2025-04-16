package com.example.helpandhour.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helpandhour.ui.theme.Jost
import com.example.helpandhour.ui.theme.PositiveButtonColor

@Composable
fun CustomPositiveButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClick: () -> Unit = {},
    text: String = "Label",
    height: Int = 50,
    width: Int = 200
){
        Button(
            onClick = onClick,
            enabled = true,
            modifier = modifier.size(width.dp, height.dp)
                .shadow(6.dp, RoundedCornerShape(6.dp)),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PositiveButtonColor
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp
            )
        ){
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = Jost,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp
                )

            )
        }
}

@Preview
@Composable
private fun CustomPositiveButtonPreview(){
    CustomPositiveButton()
}