package com.rinoindraw.myfavouriteartistcompose.data

import com.rinoindraw.myfavouriteartistcompose.model.Artist
import com.rinoindraw.myfavouriteartistcompose.model.ArtistData

class ArtistRepository {
    fun getArtist(): List<Artist> {
        return ArtistData.artist
    }

    fun searchArtist(query: String): List<Artist> {
        return ArtistData.artist.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}