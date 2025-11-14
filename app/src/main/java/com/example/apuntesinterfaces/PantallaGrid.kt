package com.example.apuntesinterfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaGrid(modifier: Modifier) {

    val datosImagenes = listOf(
        ImageData(
            "Ballena",
            "imagen",
            R.drawable.image1
        ),
        ImageData(
            "Flores",
            "imagen",
            R.drawable.image2
        ),
        ImageData(
            "Bosque",
            "imagen",
            R.drawable.image3
        ),
        ImageData(
            "Badlands",
            "imagen",
            R.drawable.image4
        ),
        ImageData(
            "Riachuelo",
            "imagen",
            R.drawable.image5
        ),
        ImageData(
            "Arbol",
            "imagen",
            R.drawable.image6
        ),
        ImageData(
            "Tucan",
            "imagen",
            R.drawable.image7
        ),
        ImageData(
            "Tortuga",
            "imagen",
            R.drawable.image8
        ),
    )
    val fuentePoppins = FontFamily(Font(R.font.poppins))

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(datosImagenes) { imageIndex ->
                Card {
                    Column {
                        Text(
                            text = stringResource(R.string.titulo, imageIndex.nombreImagen),
                            fontSize = 25.sp,
                            fontFamily = fuentePoppins
                        )
                        Image(
                            painter = painterResource(imageIndex.rutaImagen),
                            contentDescription = null
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ThumbUp,
                                    contentDescription = null
                                )
                            }
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null

            )
        }
    }
}