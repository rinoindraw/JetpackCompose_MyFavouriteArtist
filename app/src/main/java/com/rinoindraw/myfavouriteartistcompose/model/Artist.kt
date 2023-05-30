package com.rinoindraw.myfavouriteartistcompose.model

import androidx.annotation.DrawableRes

data class Artist(
    val id: String,
    val name: String,
    val descArtist: String,
    @DrawableRes val photoUrl: Int,
    @DrawableRes val albumUrl: Int,
    @DrawableRes val albumUrlTwo: Int,
    val albumTitle: String,
    val albumTitleTwo: String
)
