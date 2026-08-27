package com.example.myfirstandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstandroidapp.ui.theme.MyFirstAndroidappTheme
import androidx.compose.ui.text.TextStyle
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAndroidappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingText(
                        message = "THIS IS GROUP SAGASA!",
                        from = "FROM IT 3H",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Pink Color Gradient (Light Pink -> Hot Pink -> Deep Magenta)
    val pinkGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFF80AB), // Light Pink (Top)
            Color(0xFFFF1744), // Neon Pink/Red (Middle)
            Color(0xFFC2185B)  // Deep Magenta (Bottom)
        )
    )

    Box(modifier = modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.CH),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Text Overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message,
                fontSize = 44.sp,
                lineHeight = 48.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Black, // Ultra Bold
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    brush = pinkGradient,
                    shadow = Shadow(
                        color = Color(0xFFFF4081), // Bright Pink Glow Shadow
                        blurRadius = 25f
                    )
                )
            )

            Text(
                text = from,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold, // Extra Bold
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(top = 20.dp, end = 16.dp)
                    .align(alignment = Alignment.End),
                style = TextStyle(
                    brush = pinkGradient,
                    shadow = Shadow(
                        color = Color.Black,
                        blurRadius = 15f
                    )
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_8"
)
@Composable
fun GreetingPreview() {
    MyFirstAndroidappTheme {
        GreetingText(
            message = "THIS IS GROUP SAGASA!",
            from = "FROM IT 3H"
        )
    }
}