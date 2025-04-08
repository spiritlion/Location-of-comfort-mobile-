package com.example.locationofcomfort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.locationofcomfort.custom.screens.MainScreen
import com.example.locationofcomfort.ui.theme.LocationOfComfortTheme
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MainActivity : ComponentActivity() {

    lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("697a8f69-8ca4-4034-8d90-f2e21b4b4ca5")
        MapKitFactory.initialize(this)
        mapView = MapView(this).apply {
            map.move(
                CameraPosition(
                    Point(
                        56.999799,
                        40.973014
                    ),
                    11.0f,
                    0.0f,
                    0.0f
                )
            )
        }

        setContent {
            LocationOfComfortTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    MainScreen(modifier = Modifier.padding(paddingValues), mapView)
                }
            }
        }
        Animation(Animation.Type.SMOOTH, 300f)

        enableEdgeToEdge()
        setContent {
            LocationOfComfortTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainScreen(modifier = Modifier.padding(it), mapView = mapView)
                }
            }
        }
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }


}

@Composable
fun MapViewContainer(mapView: MapView) {
    // Здесь можно использовать AndroidView для интеграции MapView в Compose
    AndroidView(factory = { mapView }) { view ->
        // Дополнительные настройки карты можно делать здесь
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LocationOfComfortTheme {
        Greeting("Android")
    }
}