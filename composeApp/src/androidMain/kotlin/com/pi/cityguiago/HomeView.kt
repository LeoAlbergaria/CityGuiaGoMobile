package com.pi.cityguiago

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pi.cityguiago.designsystem.*
import com.pi.cityguiago.designsystem.components.*

@Composable
fun HomeView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Blue)
                .padding(Metrics.Margins.default)
        ) {
            Column {
                TextH1("Olá, Vítor 👋", colorMode = ColorMode.Secondary)
                TextBody1("Vamos explorar a Grande Vitória juntos!", colorMode = ColorMode.Secondary)
                Spacer(modifier = Modifier.height(Metrics.Margins.massive))
            }
        }

        Spacer(modifier = Modifier.height(Metrics.Margins.large))

        // Content Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Metrics.Margins.large),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBar(
                text = "",
                placeholder = "Explore a Grande Vitória",
                onTextChanged = { },
                icon = Icons.Filled.Info
            )

            Spacer(modifier = Modifier.height(Metrics.Margins.large))

            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(Metrics.RoundCorners.default)
                    )
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(Metrics.RoundCorners.default))
                    .background(White)
                    .padding(Metrics.Margins.default)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(Metrics.Margins.small)) {
                    SecondaryButton(text = "Seus Favoritos", onClick = {})
                    SecondaryButton(text = "Seus Roteiros", onClick = {})
                }
            }
        }
    }
}

