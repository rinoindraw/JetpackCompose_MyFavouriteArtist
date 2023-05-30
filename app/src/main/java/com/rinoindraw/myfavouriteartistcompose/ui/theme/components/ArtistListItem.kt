package com.rinoindraw.myfavouriteartistcompose.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rinoindraw.myfavouriteartistcompose.ui.theme.MyFavouriteArtistComposeTheme
import com.rinoindraw.myfavouriteartistcompose.ui.theme.navigation.Screen
import com.rinoindraw.myfavouriteartistcompose.R
import com.rinoindraw.myfavouriteartistcompose.ui.theme.BlueSky
import com.rinoindraw.myfavouriteartistcompose.ui.theme.DarkBlueSky

@Composable
fun ArtistListItem(
    name: String,
    photoUrl: Int,
    descArtist: String,
    albumUrl: Int,
    albumUrlTwo: Int,
    albumTitle: String,
    albumTitleTwo: String,
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            navController.navigate("${Screen.Detail.route}/$name/$photoUrl/$descArtist/$albumUrl/$albumUrlTwo/$albumTitle/$albumTitleTwo")
        }
    ) {
        Image(
            painter = painterResource(photoUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(180.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                color = BlueSky
            )
            Text(
                text = descArtist,
                color = DarkBlueSky,
                fontWeight = FontWeight.Light,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistListItemPreview() {
    MyFavouriteArtistComposeTheme {
        ArtistListItem(
            name = "Taylor Swift",
            photoUrl = R.drawable.tswiftt,
            descArtist = "Taylor Swift is an American pop and country music singer-songwriter. Five of her songs, including “Shake It Off” (2014), “Blank Space” (2014), and “Look What You Made Me Do” (2017), topped the Billboard Hot 100. She received a number of awards for her music.",
            albumUrl = R.drawable.ts1,
            albumUrlTwo = R.drawable.ts2,
            albumTitle = "Red",
            albumTitleTwo = "1989",
            modifier = Modifier,
            navController = rememberNavController(),
        )
    }
}