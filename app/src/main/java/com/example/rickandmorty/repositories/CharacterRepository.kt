package com.example.rickandmorty.repositories

import com.example.network.ApiOperation
import com.example.network.KtorClient
import com.example.network.domain.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {
    suspend fun fetchCharacter(characterId: Int): ApiOperation<Character> {
        return ktorClient.getCharacter(characterId)
    }
}