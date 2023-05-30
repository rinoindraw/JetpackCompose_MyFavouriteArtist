package com.rinoindraw.myfavouriteartistcompose

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rinoindraw.myfavouriteartistcompose.data.ArtistRepository
import com.rinoindraw.myfavouriteartistcompose.ui.theme.MyFavouriteArtistComposeTheme
import com.rinoindraw.myfavouriteartistcompose.ui.theme.components.BottomBar
import com.rinoindraw.myfavouriteartistcompose.ui.theme.detail.DetailScreen
import com.rinoindraw.myfavouriteartistcompose.ui.theme.home.HomeScreen
import com.rinoindraw.myfavouriteartistcompose.ui.theme.navigation.Screen
import com.rinoindraw.myfavouriteartistcompose.ui.theme.profile.ProfileScreen
import com.rinoindraw.myfavouriteartistcompose.ui.theme.splash.SplashScreen
import kotlinx.coroutines.delay

@Suppress("NAME_SHADOWING")
@Composable
fun MyFavouriteArtistApp(
    modifier: Modifier = Modifier,
    viewModel: MyFavouriteArtistViewModel = viewModel(factory = ViewModelFactory(ArtistRepository())),
    navController: NavHostController = rememberNavController(),
) {
    val appStartState = remember {
        mutableStateOf(AppStartState.Splash)
    }

    LaunchedEffect(key1 = appStartState) {
        delay(2000)
        appStartState.value = AppStartState.Content
    }

    Crossfade(targetState = appStartState.value) { appStartState ->
        when (appStartState) {
            AppStartState.Splash -> SplashScreen(modifier)
            AppStartState.Content -> {
                Scaffold(
                    bottomBar = {
                        BottomBar(navController)
                    },
                    modifier = modifier
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(viewModel, navController)
                        }
                        composable(Screen.Profile.route) {
                            ProfileScreen()
                        }
                        composable(Screen.Detail.route + "/{name}/{photoUrl}/{descArtist}/{albumUrl}/{albumUrlTwo}/{albumTitle}/{albumTitleTwo}") { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name")
                            val photoUrl = backStackEntry.arguments?.getString("photoUrl")?.toIntOrNull()
                            val albumUrl = backStackEntry.arguments?.getString("albumUrl")?.toIntOrNull()
                            val albumUrlTwo = backStackEntry.arguments?.getString("albumUrlTwo")?.toIntOrNull()

                            val albumTitle = backStackEntry.arguments?.getString("albumTitle")
                            val albumTitleTwo = backStackEntry.arguments?.getString("albumTitleTwo")

                            val descArtist = backStackEntry.arguments?.getString("descArtist")

                            if (name != null && photoUrl != null && descArtist != null && albumUrl != null && albumUrlTwo != null && albumTitle != null && albumTitleTwo != null ) {
                                DetailScreen(name, photoUrl, descArtist, albumUrl , albumUrlTwo, albumTitle, albumTitleTwo)
                            } else {
                                // Handle error case
                            }
                        }
                    }
                }
            }
        }
    }
}

enum class AppStartState {
    Splash,
    Content
}

@Preview(showBackground = true)
@Composable
fun MyFavouriteArtistPreview() {
    MyFavouriteArtistComposeTheme {
        MyFavouriteArtistApp()
    }
}