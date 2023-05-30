package com.rinoindraw.myfavouriteartistcompose.ui.theme.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rinoindraw.myfavouriteartistcompose.R

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val isVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible.value = true
    }

    AnimatedVisibility(
        visible = isVisible.value,
        exit = fadeOut(),
        modifier = modifier.fillMaxSize(),
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.titlebar),
                    contentDescription = "Splash Image",
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    )
}