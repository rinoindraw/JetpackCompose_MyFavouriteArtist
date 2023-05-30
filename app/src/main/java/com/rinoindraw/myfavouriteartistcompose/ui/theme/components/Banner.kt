package com.rinoindraw.myfavouriteartistcompose.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rinoindraw.myfavouriteartistcompose.R

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit,
    query: String
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.tswiftt),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar(
            query = query,
            onQueryChange = onQueryChange,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}