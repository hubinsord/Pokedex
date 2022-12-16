package com.hubinsord.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hubinsord.pokedex.pokemondetail.PokemonDetailScreen
import com.hubinsord.pokedex.pokemonlist.PokemonListScreen
import com.hubinsord.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ) {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(navController = navController)
                    }
                    composable(
//                        route = "pokdemon_detail_screen/{dominantColor}/{pokemonName}",
                        route = "pokemon_detail_screen/{pokemonName}",
                        arguments = listOf(
//                            navArgument("dominantColor") {
//                                type = NavType.IntType
//                            },
                            navArgument("pokemonName") { type = NavType.StringType }
                        )
                    ) {
//                        val dominantColor = remember {
//                            val color = it.arguments?.getInt("dominantColor")
//                            color?.let { Color(it) } ?: Color.White
//                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                        PokemonDetailScreen(
//                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
