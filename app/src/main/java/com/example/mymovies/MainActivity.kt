 package com.example.mymovies

import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.mymovies.MediaItem.*
import com.example.mymovies.ui.theme.MyMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val (value, onValueChange)=rememberSaveable{ mutableStateOf("")}
                    StateSample(value = value,
                        onValueChange =  onValueChange
                    )
                }
            }
        }
    }
}


@Composable
fun StateSample(value: String, onValueChange:(String) -> Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
            ){
        TextField(
            value = value,
            onValueChange = {onValueChange},
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(onClick = {onValueChange("")},
        modifier = Modifier
            .fillMaxWidth(),
            enabled = value.isNotEmpty()
        ) {
            Text(text = "Clear")
        }
    }
}
 @ExperimentalCoilApi
 //@Preview(showBackground = true)
 @Composable
 fun MediaList() {
     LazyVerticalGrid(
         contentPadding = PaddingValues(2.dp),
         columns =GridCells.Adaptive(150.dp)
     ){
         items(getMedia()){ item ->
             MediaListItem(item, Modifier.padding(2.dp))
         }
 }
 }
 @ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
     Column (
         modifier = Modifier
             ){
         this
         Box(
             modifier = Modifier
                 .height(200.dp)
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
             if (item.type == Type.VIDEO) {
                 Icon(
                     imageVector = Icons.Default.PlayCircleOutline,
                     contentDescription = null,
                     modifier = Modifier.size(92.dp),
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
                 .padding(16.dp)
         ) {
             Text(text = item.title, style = MaterialTheme.typography.h6)
         }
     }

     MyMoviesTheme {

     }
 }