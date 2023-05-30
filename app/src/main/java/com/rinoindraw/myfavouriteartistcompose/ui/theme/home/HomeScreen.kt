package com.rinoindraw.myfavouriteartistcompose.ui.theme.home

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rinoindraw.myfavouriteartistcompose.MyFavouriteArtistViewModel
import com.rinoindraw.myfavouriteartistcompose.ui.theme.components.*
import com.rinoindraw.myfavouriteartistcompose.ui.theme.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MyFavouriteArtistViewModel,
    navController: NavHostController
) {
    val groupedArtist by viewModel.groupedArtist.collectAsState()
    val query by viewModel.query

    Box(modifier = Modifier.fillMaxSize()) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton: Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            item {
                Banner(
                    onQueryChange = viewModel::search,
                    query = query
                )
            }
            groupedArtist.forEach { (initial, artist) ->
                stickyHeader {
                    CharacterHeader(initial)
                }
                items(artist, key = { it.id }) { artistItem ->
                    ArtistListItem(
                        name = artistItem.name,
                        photoUrl = artistItem.photoUrl,
                        descArtist = artistItem.descArtist,
                        navController = navController,
                        albumUrl = artistItem.albumUrl,
                        albumUrlTwo = artistItem.albumUrlTwo,
                        albumTitle = artistItem.albumTitle,
                        albumTitleTwo = artistItem.albumTitleTwo,
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement(tween(durationMillis = 100))
                            .clickable {
                                navController.navigate(Screen.Detail.route)
                            }
                    )
                }
            }
        }
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                onClick = {
                    scope.launch {
                        listState.scrollToItem(index = 0)
                    }
                }
            )
        }
    }
}