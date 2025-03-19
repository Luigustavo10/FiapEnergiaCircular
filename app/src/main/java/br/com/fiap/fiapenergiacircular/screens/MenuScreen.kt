import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import br.com.fiap.fiapenergiacircular.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    val categorias = listOf(
        stringResource(id = R.string.eletrodomestico),
        stringResource(id = R.string.roupas),
        stringResource(id = R.string.moveis),
        stringResource(id = R.string.eletronicos),
        stringResource(id = R.string.livros))
    val produtos = listOf(
        stringResource(id = R.string.geladeira),
        stringResource(id = R.string.camiseta),
        stringResource(id = R.string.sofa),
        stringResource(id = R.string.notebook),
        stringResource(id = R.string.livro_kotlin))

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name), color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* Ação do menu lateral */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2E7D32))
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .background(Color(0xFFE8F5E9))
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(stringResource(id = R.string.buscar_produtos)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color(0xFF2E7D32)) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF2E7D32),
                    unfocusedBorderColor = Color(0xFF81C784)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow {
                items(categorias) { categoria ->
                    Button(
                        onClick = { /* Filtrar produtos */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(categoria, color = Color.White)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(produtos) { produto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { navController.navigate("lista") },
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E6C9))
                    ) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Color(0xFF2E7D32))
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(produto, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
                                //Text("Descrição do $produto", fontSize = 14.sp, color = Color(0xFF388E3C))
                                Text(stringResource(id = R.string.descricao_produto), fontSize = 14.sp, color = Color(0xFF388E3C))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(containerColor = Color(0xFF388E3C)) {
        // Item Home
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("menu") },
            icon = { Icon(Icons.Default.Home, "Home", tint = Color.White) },
            label = { Text(stringResource(id = R.string.home), color = Color.White) }
        )

        // Item Pedidos
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("pedidos") },
            icon = { Icon(Icons.Default.ShoppingCart, "Pedidos", tint = Color.White) },
            label = { Text(stringResource(id = R.string.pedidos), color = Color.White) }
        )

        // Item Perfil
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("perfil") },
            icon = { Icon(Icons.Default.Person, "Perfil", tint = Color.White) },
            label = { Text(stringResource(id = R.string.perfil), color = Color.White) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesItemScreen(itemNome: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(itemNome, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2E7D32))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .background(Color(0xFFE8F5E9))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Gray)
            ) {
                Text("Imagem do Produto", modifier = Modifier.align(Alignment.Center), color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(itemNome, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
            Text("Descrição detalhada do item selecionado.", fontSize = 16.sp, color = Color(0xFF388E3C))
            Text("Condição: Novo", fontSize = 14.sp, color = Color(0xFF4CAF50))
            Text("Preço: R$ 100,00", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
        }
    }
}