package com.hubinsord.pokedex.data.remote.responses

import com.squareup.moshi.Json

data class Ability(
    val ability: AbilityX,
    @Json(name = "is_hidden") val isHidden : Boolean,
    val slot: Int
)