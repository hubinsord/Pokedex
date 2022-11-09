package com.hubinsord.pokedex.data.remote.responses

import com.squareup.moshi.Json

data class GenerationIii(
    val emerald: Emerald,
    @Json(name = "firered-leafgreen") val fireredLeafgreen: FireredLeafgreen,
    @Json(name = "ruby-sapphire")val rubySapphire: RubySapphire
)