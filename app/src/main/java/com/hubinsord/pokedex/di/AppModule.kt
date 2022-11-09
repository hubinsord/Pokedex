package com.hubinsord.pokedex.di

import com.hubinsord.pokedex.data.remote.PokeApi
import com.hubinsord.pokedex.domain.PokemonRepository
import com.hubinsord.pokedex.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(PokeApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providePokeApi(retrofit: Retrofit): PokeApi = retrofit.create(PokeApi::class.java)

    @Singleton
    @Provides
    fun providePokemonRepository(pokeApi: PokeApi): PokemonRepository =
        PokemonRepositoryImpl(pokeApi)
}