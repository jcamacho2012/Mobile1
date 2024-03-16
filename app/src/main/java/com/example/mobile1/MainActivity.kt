package com.example.mobile1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1.ui.theme.Mobile1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .size(300.dp)
        ) {
            Text(
                text = "Box Text 1",
                color = Color.Blue,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
            Text(
                text = "Box Text 2",
                color = Color.Blue,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
            )
        }
        Text(
            text = "Column Text $name",
            color = Color.Blue,
            fontSize = 30.sp,
            modifier = Modifier
                .background(Color.Green)
                .padding(16.dp)
//                .background(Color.Green)
        )
        Text(
            text = "Column Text 2",
            color = Color.Blue,
            fontSize = 30.sp,
            modifier = Modifier
                .background(Color.Green)
                .padding(16.dp)
//                .background(Color.Green)
                .width(120.dp)
        )
        Row(
            modifier = Modifier
//                .background(Color.Blue)
                .width(400.dp),
//                .size(300.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Row Text 1",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(16.dp)
//                    .background(Color.Green)
            )
            Text(
                text = "Row Text 2",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(16.dp)
//                    .background(Color.Green)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Mobile1Theme {
        Greeting("Jose")
    }
}