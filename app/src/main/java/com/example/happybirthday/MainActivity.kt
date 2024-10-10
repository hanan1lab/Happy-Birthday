package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.verticalGradient(  // Menggunakan gradient pada background
                            colors = listOf(Color.Blue, Color.Cyan)
                        )),
                    color = Color.Transparent
                ) {
                    GreetingText(
                        message = "Happy Birthday Hanan!",
                        from = "From Frezy",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.gambar),  // Memanggil gambar
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .shadow(8.dp, CircleShape)  // Menambahkan bayangan di sekitar gambar
                .background(Color.White)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        // Box untuk menempatkan teks di dalam kotak yang lebih estetis
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .shadow(10.dp, RoundedCornerShape(16.dp))  // Menambahkan bayangan untuk memberi efek 3D
                .clip(RoundedCornerShape(16.dp))  // Membuat sudut lebih melengkung
                .background(Color.White)  // Latar belakang kotak berwarna putih
                .padding(24.dp)  // Padding di dalam kotak
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = message,
                    fontSize = 36.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,  // Warna teks
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = from,
                    fontSize = 24.sp,
                    color = Color.Gray,  // Warna teks "From Frezy"
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy Birthday Hanan!", from = "From Frezy")
    }
}
