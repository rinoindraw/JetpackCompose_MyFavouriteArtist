package com.rinoindraw.myfavouriteartistcompose.ui.theme.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rinoindraw.myfavouriteartistcompose.R
import com.rinoindraw.myfavouriteartistcompose.ui.theme.BlueSky
import com.rinoindraw.myfavouriteartistcompose.ui.theme.DarkBlueSky

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val aboutPhoto = R.drawable.about_photo
    val name = stringResource(R.string.my_name)
    val email = stringResource(R.string.email)
    val bangkit = stringResource(R.string.bangkit_desc)
    val desc = stringResource(R.string.my_desc)

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()

        ) {
            Image(
                painter = painterResource(aboutPhoto),
                contentDescription = "Profile Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(260.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .border(
                        width = 5.dp,
                        color = BlueSky,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(shape = RoundedCornerShape(16.dp))
            )
            Text(
                text = name,
                color = BlueSky,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
            Text(
                text = email,
                color = BlueSky,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )
            Text(
                text = bangkit,
                color = BlueSky,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )
            Text(
                text = desc,
                color = DarkBlueSky,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            )
        }
    }
}