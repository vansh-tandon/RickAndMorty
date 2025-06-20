package com.example.network.remote


import com.example.network.domain.Character
import com.example.network.domain.CharacterGender
import com.example.network.domain.CharacterStatus
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacterResponse(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    @Serializable
    data class Location(
        val name: String,
        val url: String
    )

    @Serializable
    data class Origin(
        val name: String,
        val url: String
    )
}

fun RemoteCharacterResponse.toDomainCharacter(): Character {
    val characterGender = when (gender?.lowercase()) {
        "female" -> CharacterGender.Female
        "male" -> CharacterGender.Male
        "genderless" -> CharacterGender.Genderless
        else -> CharacterGender.Unknown
    }
    val characterStatus = when (status?.lowercase()) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }
    return Character(
        created = created,
        episodesIds = episode.map { it.substring(it.lastIndexOf("/") + 1).toInt() },
        gender = characterGender,
        id = id,
        imageUrl = image,
        location = Character.Location(name = location.name, url = location.url),
        name = name,
        origin = Character.Origin(name = origin.name, url = origin.url),
        species = species,
        status = characterStatus,
        type = type
    )
}