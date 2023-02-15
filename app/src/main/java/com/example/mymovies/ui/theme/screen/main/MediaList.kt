package com.example.mymovies
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.mymovies.model.MediaItem
import com.example.mymovies.model.getMedia
import com.example.mymovies.ui.theme.MyMoviesApp
import com.example.mymovies.ui.theme.screen.common.Thumb

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun MediaList(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.column_min_wedith)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        modifier = modifier
    ){
        items(getMedia()){
            MediaListItem(
                mediaItem = it,
                onClick = { onClick(it) },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)),

            )
        }
    }
}
@ExperimentalCoilApi
@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.clickable { onClick() },
        elevation = 0.dp,
        //shape = RoundedCornerShape(8.dp)
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary
    ) {
        Column{
            Thumb(mediaItem)
            Title(mediaItem)
        }
    }

}
    @Composable
    private fun Title(mediaItem: MediaItem) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                //.background(MaterialTheme.colors.secondary)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = mediaItem.title,
                style = MaterialTheme.typography.h6
            )
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun MediaListItemPreview() {
        MyMoviesApp {
            val mediaItem = MediaItem(1, "Item1", "", MediaItem.Type.VIDEO)
            //MediaListItem(mediaItem = mediaItem, navController = navController)
        }
    }
