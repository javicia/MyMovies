package com.example.mymovies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.mymovies.model.MediaItem
import com.example.mymovies.model.getMedia

@Composable
fun MediaList(modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.column_min_wedith)),
        modifier = Modifier
    ){
        items(getMedia()){ item ->
            MediaListItem(item, Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
        }
    }
}
@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaListItem(
    item: MediaItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
    ) {
        this
        Box(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.cell_thumb_height))
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = item.thumb).apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                            crossfade(5000)
                        }).build()
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            if (item.type == MediaItem.Type.VIDEO) {
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.cell_play_icon_size)),
                    tint = Color.White
                )
                //Para cargar icono de Drawable Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground))
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(text = item.title, style = MaterialTheme.typography.h6)
        }
    }
}
@ExperimentalFoundationApi
@Preview
@Composable
fun MediaListPreview(){
    MediaList()
}

