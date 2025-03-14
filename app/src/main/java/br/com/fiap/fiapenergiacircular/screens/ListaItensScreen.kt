package br.com.fiap.fiapenergiacircular.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Item(
    val id: Int,
    val nome: String,
    val categoria: String,
    val preco: String
)

@Composable
fun ListaItensScreen(navController: NavController) {
    val itens = listOf(
        Item(1, "Geladeira Brastemp", "Eletrodoméstico", "R$ 800"),
        Item(2, "Notebook Dell", "Informática", "R$ 1500"),
        Item(3, "Sofá Retrátil", "Móveis", "R$ 1200"),
        Item(4, "Bicicleta Caloi", "Esporte", "R$ 600")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3A3A3A))
            .padding(16.dp)
    ) {
        LazyColumn {
            items(itens) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { navController.navigate("detalhes/${item.id}") }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = item.nome, fontSize = 20.sp, color = Color.Black)
                        Text(text = item.categoria, fontSize = 16.sp, color = Color.Gray)
                        Text(text = item.preco, fontSize = 18.sp, color = Color.Blue)
                    }
                }
            }
        }
    }
}
