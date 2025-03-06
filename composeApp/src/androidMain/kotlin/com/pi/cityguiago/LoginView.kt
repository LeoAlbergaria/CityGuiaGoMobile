package com.pi.cityguiago

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import com.pi.cityguiago.designsystem.*
import com.pi.cityguiago.designsystem.components.TextFieldWithTitle

@Composable
fun LoginView(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Metrics.Margins.default),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Bom te ver de novo",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(Metrics.Margins.small))
        Text(
            text = "Faça seu login no app",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(Metrics.Margins.huge))

        Column(modifier = Modifier.fillMaxWidth()) {
            TextFieldWithTitle(
                title = "Email",
                placeholder = "Digite seu email",
                text = email,
                onTextChanged = { email = it }
            )
            Spacer(modifier = Modifier.height(Metrics.Margins.default))
            TextFieldWithTitle(
                title = "Senha",
                placeholder = "Sua senha aqui",
                text = password,
                onTextChanged = { password = it },
                isPassword = true
            )
        }

        Spacer(modifier = Modifier.height(Metrics.Margins.huge))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Metrics.RoundCorners.default)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue)
        ) {
            Row(
                modifier = Modifier.padding(Metrics.Margins.small),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Entrar", tint = White)
                Spacer(modifier = Modifier.width(Metrics.Margins.small))
                Text(text = "Entrar", color = White)
            }
        }

        Spacer(modifier = Modifier.height(Metrics.Margins.small))

        Text(
            text = "Faça seu cadastro",

            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { navController.navigate("register") }
        )
    }
}
