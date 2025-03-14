package br.com.fiap.fiapenergiacircular.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetalhesItemScreen(navController: NavController, itemId: Int) {
    val itens = mapOf(
        1 to Item(1, "Geladeira Brastemp", "Eletrodoméstico", "R$ 800"),
        2 to Item(2, "Notebook Dell", "Informática", "R$ 1500"),
        3 to Item(3, "Sofá Retrátil", "Móveis", "R$ 1200"),
        4 to Item(4, "Bicicleta Caloi", "Esporte", "R$ 600")
    )

    val item = itens[itemId] ?: return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C3E50))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Detalhes do Item", fontSize = 24.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Nome: ${item.nome}", fontSize = 20.sp, color = Color.White)
            Text(text = "Categoria: ${item.categoria}", fontSize = 18.sp, color = Color.Gray)
            Text(text = "Preço: ${item.preco}", fontSize = 22.sp, color = Color.Green)
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("menu") },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "Voltar", fontSize = 18.sp, color = Color.Blue)
            }
        }
    }
}
