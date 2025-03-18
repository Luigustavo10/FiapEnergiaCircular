package br.com.fiap.fiapenergiacircular

import DetalhesItemScreen
import MenuScreen
import android.os.Bundle
import br.com.fiap.fiapenergiacircular.screens.LoginScreen


import androidx.navigation.compose.composable



import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.fiapenergiacircular.screens.CadastroScreen
import br.com.fiap.fiapenergiacircular.screens.PedidosScreen
import br.com.fiap.fiapenergiacircular.screens.PerfilScreen
import br.com.fiap.fiapenergiacircular.ui.theme.FiapEnergiaCircularTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiapEnergiaCircularTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") { LoginScreen(navController) }
                        composable("cadastro") { CadastroScreen(navController) }
                        composable("menu") { MenuScreen(navController) }
                        composable("pedidos") { PedidosScreen(navController, "FIAP") }
                        composable("perfil") { PerfilScreen(navController) }
                    }
                }
            }
        }
    }
}