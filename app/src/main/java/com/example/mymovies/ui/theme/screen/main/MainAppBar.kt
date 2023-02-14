package com.example.mymovies

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource

@Composable
fun MainAppBar(){
                TopAppBar(
                    title = { Text(text = stringResource(id = R.string.app_name)) },
                    actions = {
                        AppBarAction(
                            imageVector = Icons.Default.Search,
                        onclick = { /*TODO*/ })
                        AppBarAction(
                            imageVector = Icons.Default.Share,
                            onclick = { /*TODO*/ })
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    }
                )
            }

@Composable
private fun AppBarAction(
    imageVector: ImageVector,
    onclick: () -> Unit
    )
 {
    IconButton(onClick = onclick) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null
        )
    }
}

