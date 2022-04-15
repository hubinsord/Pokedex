package com.hubinsord.pokedex.repository

import com.hubinsord.pokedex.core.wrapper.Resource
import com.hubinsord.pokedex.data.remote.PokeApi
import com.hubinsord.pokedex.data.remote.responses.Pokemon
import com.hubinsord.pokedex.data.remote.responses.PokemonList
import com.hubinsord.pokedex.domain.PokemonRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject constructor(private val api: PokeApi): PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An error occured")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An error occured")
        }
        return Resource.Success(response)
    }
}