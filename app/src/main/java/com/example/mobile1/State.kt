package com.example.mobile1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TapCounter() {
    var counter by remember {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = counter.toString(),
            fontSize = 30.sp,
            modifier = Modifier
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            onClick = {
            counter += 1
            // click
        }) {
            Icon(imageVector = Icons.Default.Build, contentDescription = null)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Tap me!")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            onClick = {
                counter = 0
                // click
            },
        ) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Reset Counter")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TapPreview() {
    TapCounter()
}