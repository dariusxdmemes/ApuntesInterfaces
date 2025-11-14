package com.example.apuntesinterfaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.apuntesinterfaces.ui.theme.ApuntesInterfacesTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApuntesInterfacesTheme {
                val topBarHeaders = listOf(
                    "LazyColumn",
                    "LazyRow",
                    "LazyGrid"
                )

                val snackBarHostState = remember { SnackbarHostState() }
                val corutine = rememberCoroutineScope()
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()

                val currentRoute = backStackEntry?.destination?.route
                val topBarIndex = when (currentRoute) {
                    "PantallaRowColumn" -> 0
                    "PantallaLazyRow" -> 1
                    "PantallaGrid" -> 2
                    else -> 0
                }


                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            ),
                            title = {
                                Text(
                                    text = topBarHeaders[topBarIndex]
                                )
                            },
                            navigationIcon = {
                                var dropDownExpanded by remember { mutableStateOf(false) }

                                Box {
                                    IconButton(
                                        onClick = { dropDownExpanded = !dropDownExpanded }
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Default.List,
                                            contentDescription = "Icono Izquierda"
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = dropDownExpanded,
                                        onDismissRequest = { dropDownExpanded = !dropDownExpanded }
                                    ) {
                                        DropdownMenuItem(
                                            text = { Text(text = stringResource(R.string.dropDown1)) },
                                            onClick = {  }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(text = stringResource(R.string.dropDown2)) },
                                            onClick = {  }
                                        )
                                        DropdownMenuItem(
                                            text = { Text(text = stringResource(R.string.dropDown3)) },
                                            onClick = {  }
                                        )
                                    }
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = {/* Navegar a una pantalla */}
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AccountBox,
                                        contentDescription = "Icono Derecha 1"
                                    )
                                }
                                IconButton(
                                    onClick = {/* Navegar a una pantalla */}
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "Icono Derecha 2"
                                    )
                                }
                                IconButton(
                                    onClick = {/* Navegar a una pantalla */}
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = "Icono Derecha 3"
                                    )
                                }
                            }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = currentRoute == "PantallaLazyColumn",
                                onClick = {  navController.navigate("PantallaLazyColumn") },
                                label = { Text(stringResource(R.string.pantallaColumn)) },
                                icon = {
                                    Icon(
                                        Icons.Default.AccountCircle,
                                        contentDescription = null
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = currentRoute == "PantallaLazyRow",
                                onClick = { navController.navigate("PantallaLazyRow") },
                                label = { Text(stringResource(R.string.pantallaRow)) },
                                icon = {
                                    Icon(
                                        Icons.Default.AccountCircle,
                                        contentDescription = null
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = currentRoute == "PantallaGrid",
                                onClick = { navController.navigate("PantallaGrid") },
                                label = { Text(stringResource(R.string.pantallaGrid)) },
                                icon = {
                                    Icon(
                                        Icons.Default.AccountCircle,
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    }
                ) { innerPadding ->



                    NavHost(
                        navController = navController,
                        startDestination = "PantallaLazyColumn",
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        composable("PantallaLazyColumn") {
                            PantallaLazyColumn(
                                modifier = Modifier
                                    .fillMaxSize(),
                                snackbarHostState = snackBarHostState,
                                coroutineScope = corutine,
                            )
                        }
                        composable("PantallaLazyRow") {
                            PantallaLazyRow(
                                modifier = Modifier
                                    .fillMaxSize(),
                            )
                        }
                        composable("PantallaGrid") {
                            PantallaGrid(
                                modifier = Modifier
                                    .fillMaxSize(),
                            )
                        }
                    }
                }
            }
        }
    }
}