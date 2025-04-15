package com.example.helpandhour.ui.screens.LogIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.helpandhour.R
import com.example.helpandhour.ui.theme.DefaultBackground
import com.example.helpandhour.ui.theme.DefaultComponentColor
import com.example.helpandhour.ui.theme.HelpAndHourTheme
import com.example.helpandhour.ui.theme.LogoImgs
import com.example.helpandhour.ui.theme.White

@Composable
fun LogIn(){
    LogInContent()
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun LogInContent(){
    Scaffold (
    contentColor = DefaultBackground,
        content = {padding ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(padding),
                contentAlignment = Alignment.Center)
            {
                Card(modifier = Modifier
                    .fillMaxWidth(0.8f),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = DefaultComponentColor)
                ){
                    Column(modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        GlideImage(
                            model = LogoImgs.LOGO_DEFAULT,
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(bottom = 16.dp)
                        )

                        Text(
                            text= "Login",
                            color = White,
                            fontStyle =

                        )

                    }
                    }

                }


        })
}

@Preview
@Composable
private fun LogInContentPreview(){
    HelpAndHourTheme {
        LogIn()
    }
}