package com.example.apuntesinterfaces

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PantallaLazyColumn(modifier: Modifier, snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {

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
    var cardIsClicked by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(R.string.pantallaColumn),
            fontWeight = FontWeight.Bold,
            fontFamily = fuentePoppins,
            fontSize = 30.sp
        )
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(10.dp)
        ) {
            items(datosImagenes) { imageIndex ->
                Card(
                    modifier = Modifier
                        .padding(10.dp),
                    onClick = {
                        cardIsClicked = !cardIsClicked
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(imageIndex.nombreImagen)
                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                start = 10.dp,
                                top = 5.dp,
                                bottom = 5.dp
                            )
                    ) {
                        Text(
                            text = stringResource(R.string.titulo, imageIndex.nombreImagen),
                            fontWeight = FontWeight.Bold,
                            fontFamily = fuentePoppins
                        )
                    }
                    Image(
                        painter = painterResource(imageIndex.rutaImagen),
                        contentDescription = imageIndex.descripImagen
                    )
                    FilledTonalButton(
                        colors = ButtonDefaults.filledTonalButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
                        ),
                        modifier = Modifier
                            .padding(5.dp),
                        onClick = {
                            Toast.makeText(context, imageIndex.nombreImagen, Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(
                            text = imageIndex.nombreImagen
                        )
                    }
                }
            }
        }
    }
}