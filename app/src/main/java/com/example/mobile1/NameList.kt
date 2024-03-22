package com.example.mobile1

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameList() {
    var name by remember {
        mutableStateOf("")
    }

    var names by remember {
        mutableStateOf(listOf<String>())
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(value = name,
                placeholder = { Text("Ingresar texto") },
                onValueChange = { text ->
                    name = text
                })
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        names = names + name
                        name = ""
                    } else {
                        Toast.makeText(context, "Ingresar valor", Toast.LENGTH_SHORT).show()
                    }
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
//        Column {
//           for(name in names) @androidx.compose.runtime.Composable { currentName: String ->
//               Text(text = currentName)
//           }
//        }
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = names) { currentName ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.Green,
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        text = currentName,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                Divider()
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListPreview() {
    NameList()
}