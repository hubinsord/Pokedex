package com.hubinsord.pokedex.data.remote.responses

import com.squareup.moshi.Json

data class GenerationVii(
    val icons: Icons,
    @Json(name = "ultra-sun-ultra-moon")val ultraSunUltraMoon: UltraSunUltraMoon
)