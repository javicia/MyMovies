package com.example.mymovies.ui.theme.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview (showBackground = true, widthDp = 400, heightDp = 400)
fun DetailScreen(){
Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
){
    Text(
        text = "Detail Screen",
        style = MaterialTheme.typography.h4
    )
}
}