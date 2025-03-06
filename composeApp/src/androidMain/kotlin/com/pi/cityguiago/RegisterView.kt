package com.pi.cityguiago

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavHostController
import com.pi.cityguiago.designsystem.*
import com.pi.cityguiago.designsystem.components.TextFieldWithTitle

@Composable
fun RegisterView(navController: NavHostController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Metrics.Margins.default),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Faça seu cadastro no app!",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(Metrics.Margins.huge))

        TextFieldWithTitle(
            title = "Qual o seu nome completo?",
            placeholder = "Nome completo aqui",
            text = fullName,
            onTextChanged = { fullName = it }
        )
        Spacer(modifier = Modifier.height(Metrics.Margins.default))

        TextFieldWithTitle(
            title = "Qual o seu email?",
            placeholder = "Insira seu email aqui",
            text = email,
            onTextChanged = { email = it }
        )
        Spacer(modifier = Modifier.height(Metrics.Margins.default))

        TextFieldWithTitle(
            title = "Senha",
            placeholder = "Mínimo 8 caracteres",
            text = password,
            onTextChanged = { password = it },
            isPassword = true
        )
        Spacer(modifier = Modifier.height(Metrics.Margins.default))

        TextFieldWithTitle(
            title = "Repita a Senha",
            placeholder = "Repita a senha aqui",
            text = confirmPassword,
            onTextChanged = { confirmPassword = it },
            isPassword = true
        )

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
                Text(
                    text = "Cadastrar",
                    color = White
                )
            }
        }

        Spacer(modifier = Modifier.height(Metrics.Margins.small))

        Text(
            text = "Já é cadastrado? Entre aqui",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { navController.popBackStack() }
        )
    }
}

