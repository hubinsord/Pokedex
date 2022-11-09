package com.hubinsord.pokedex.data.remote.responses

import com.squareup.moshi.Json

data class GenerationI(

    @Json(name = "red-blue" )val redBlue: RedBlue,
    val yellow: Yellow
)