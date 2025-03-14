package br.com.fiap.fiapenergiacircular.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PerfilScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Ícone de perfil",
            tint = Color.Gray,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(text = "Atividade Fiap", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(text = "atividade.fiap@gmail.com", fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {  },
            colors =  ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Editar Perfil")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {},
            colors =  ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ver Avaliações")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Meus Itens", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
