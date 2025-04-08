package com.example.locationofcomfort.custom.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.locationofcomfort.MapViewContainer
import com.yandex.mapkit.mapview.MapView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, mapView: MapView) {
    var drawerState by remember { mutableStateOf(DrawerValue.Closed) }
    val drawerWidth = 150.dp // Ширина вашего Drawer
    Column(modifier) {
        ModalNavigationDrawer(
            drawerState = rememberDrawerState(initialValue = drawerState),
            drawerContent = {
                // Содержимое вашего Drawer
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(drawerWidth)
                        .background(Color.Gray)
                ) {
                    // Добавьте сюда элементы навигации
                }
            },
            content = {
                Row {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                drawerState = if (drawerState == DrawerValue.Open) {
                                    DrawerValue.Closed
                                } else {
                                    DrawerValue.Open
                                }
                            }
                    )
                    MapViewContainer(mapView)
                }
            },
            scrimColor = Color.Transparent // Убираем затемнение
        )
    }
}