package com.example.rickandmorty.components.navigation

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetails(val characterId: Int)

@Serializable
data class CharacterEpisodes(val characterId: Int)