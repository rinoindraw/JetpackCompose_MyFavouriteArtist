package com.rinoindraw.myfavouriteartistcompose.ui.theme.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rinoindraw.myfavouriteartistcompose.R

@Composable
fun DetailScreen(
    name: String,
    photoUrl: Int,
    descArtist: String,
    albumUrl: Int,
    albumUrlTwo: Int,
    albumTitle: String,
    albumTitleTwo: String,
    modifier: Modifier = Modifier
) {
    val painter = painterResource(photoUrl)

    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                )
                Text(
                    text = name,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                )
                Text(
                    text = descArtist,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(albumUrl),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                        Text(
                            text = albumTitle,
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 8.dp, bottom = 16.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 16.dp, top = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(albumUrlTwo),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                        Text(
                            text = albumTitleTwo,
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 8.dp, bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }
}