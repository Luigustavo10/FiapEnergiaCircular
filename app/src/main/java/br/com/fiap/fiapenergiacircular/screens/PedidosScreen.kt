package br.com.fiap.fiapenergiacircular.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PedidosScreen(navController: NavController, cliente: String?) {
    val pedidos = listOf(
        Pedido("1234", "15/05/2024", listOf("Geladeira Brastemp", "Sofá Retrátil"), "R$ 2.000,00", "Entregue"),
        Pedido("5678", "10/05/2024", listOf("Notebook Dell"), "R$ 1.500,00", "Em transporte"),
        Pedido("9012", "01/05/2024", listOf("Bicicleta Caloi", "Mochila"), "R$ 800,00", "Processando")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Seus Pedidos - ${cliente ?: "Visitante"}",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2E7D32),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(pedidos) { pedido ->
                PedidoCard(pedido)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("menu") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32))
        ) {
            Text("Voltar ao Menu", color = Color.White)
        }
    }
}

@Composable
fun PedidoCard(pedido: Pedido) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Pedido #${pedido.numero}", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32), fontSize = 18.sp)
            Text("Data: ${pedido.data}", fontSize = 14.sp)
            Text("Itens: ${pedido.itens.joinToString(", ")}", fontSize = 14.sp)
            Text("Total: ${pedido.total}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text("Status: ${pedido.status}", fontSize = 14.sp, color = Color(0xFF757575))
        }
    }
}

data class Pedido(
    val numero: String,
    val data: String,
    val itens: List<String>,
    val total: String,
    val status: String
)
