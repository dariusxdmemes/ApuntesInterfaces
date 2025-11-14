package com.example.apuntesinterfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PantallaLazyRow(modifier: Modifier) {

    val fuentePoppins = FontFamily(Font(R.font.poppins))
    val datosImagenes1 = listOf(
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
    )
    val datosImagenes2 = listOf(
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

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(R.string.pantallaRow),
            fontWeight = FontWeight.Bold,
            fontFamily = fuentePoppins,
            fontSize = 30.sp
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(datosImagenes1) { imageIndex ->
                Image(
                    painter = painterResource(imageIndex.rutaImagen),
                    contentDescription = imageIndex.descripImagen,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.titulo, imageIndex.nombreImagen),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fuentePoppins
                    )
                    Text(
                        text = imageIndex.descripImagen,
                        fontFamily = fuentePoppins
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .size(20.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(datosImagenes2) { imageIndex ->
                Image(
                    painter = painterResource(imageIndex.rutaImagen),
                    contentDescription = imageIndex.descripImagen,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.titulo, imageIndex.nombreImagen),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fuentePoppins
                    )
                    Text(
                        text = imageIndex.descripImagen,
                        fontFamily = fuentePoppins
                    )
                }
            }
        }
    }
}