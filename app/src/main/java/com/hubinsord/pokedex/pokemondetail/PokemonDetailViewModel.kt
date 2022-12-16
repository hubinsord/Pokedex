package com.hubinsord.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.hubinsord.pokedex.core.wrapper.Resource
import com.hubinsord.pokedex.data.remote.responses.Pokemon
import com.hubinsord.pokedex.domain.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}