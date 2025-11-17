package com.example.apuntesinterfaces

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.apuntesinterfaces.ui.theme.Typography

@Composable
fun PantallaLazyStaggeredGrid(modifier: Modifier, navController: NavHostController) {

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
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("PantallaLazyColumn") }
        ) {
            Text(
                text = "Volver"
            )
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .padding(5.dp)
        ) {
            items(datosImagenes) { imagen ->
                Box(
                    modifier = Modifier
                        .padding(5.dp),
                ) {
                    Image(
                        painter = painterResource(imagen.rutaImagen),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height((150..350).random().dp)
                            .clickable {  }
                    )
                    Text(
                        text = imagen.nombreImagen,
                        style = Typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopStart)
                            .background(color = Color.Black.copy(alpha = 0.5f))
                            .padding(start = 5.dp)
                    )
                }
            }
        }
    }
}