package com.example.locationofcomfort.custom.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var drawerState by remember { mutableStateOf(DrawerValue.Closed) }
    val drawerWidth = 300.dp // Ширина вашего Drawer
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
                Box(modifier = Modifier.fillMaxSize()) {
                    Button(onClick = {
                        drawerState = if (drawerState == DrawerValue.Open) {
                            DrawerValue.Closed
                        } else {
                            DrawerValue.Open
                        }
                    }) {
                        Text("Toggle Drawer")
                    }
                }
            },
            scrimColor = Color.Transparent // Убираем затемнение
        )
    }
}