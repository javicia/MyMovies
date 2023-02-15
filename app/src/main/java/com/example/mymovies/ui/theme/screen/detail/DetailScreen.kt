package com.example.mymovies.ui.theme.screen.detail


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.model.getMedia
import com.example.mymovies.ui.theme.screen.common.Thumb


@ExperimentalCoilApi
@Composable
fun DetailScreen(mediaId: Int){
val mediaItem = remember {getMedia().first{it.id == mediaId}}
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = mediaItem.title)})}
            ) {padding ->

            Thumb(mediaItem = mediaItem, Modifier.padding(padding))
    }

}