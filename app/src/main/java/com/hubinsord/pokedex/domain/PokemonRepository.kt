package com.hubinsord.pokedex.domain

import com.hubinsord.pokedex.core.wrapper.Resource
import com.hubinsord.pokedex.data.remote.responses.Pokemon
import com.hubinsord.pokedex.data.remote.responses.PokemonList

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>

}