package com.example.rickandmorty.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object CharacterDetails : Screen("character_details/{characterId}")

    data object CharacterEpisode : Screen(
        route = "character_episode/{characterId}", navArguments = listOf(
            navArgument(
                "characterId"
            ) { type = NavType.StringType })
    ) {
        fun createRoute(characterId: Int) = "character_episode/${characterId}"
    }
}
