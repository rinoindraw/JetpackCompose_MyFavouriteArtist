package com.rinoindraw.myfavouriteartistcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.rinoindraw.myfavouriteartistcompose.ui.theme.splash.SplashScreen
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MyFavouriteArtistAppTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSplashScreenDisplayed() {
        composeTestRule.setContent {
            SplashScreen()
        }
        composeTestRule.onNodeWithText("My App Splash Screen").assertIsDisplayed()
    }

    @Test
    fun testContentScreenDisplayed() {
        composeTestRule.setContent {
            MyFavouriteArtistApp()
        }
    }

}