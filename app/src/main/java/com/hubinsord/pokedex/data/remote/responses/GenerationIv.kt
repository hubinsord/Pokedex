package com.hubinsord.pokedex.data.remote.responses

import com.squareup.moshi.Json

data class GenerationIv(
    @Json(name = "diamond-pearl") val diamondPearl: DiamondPearl,
    @Json(name = "heartgold-soulsilver") val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)