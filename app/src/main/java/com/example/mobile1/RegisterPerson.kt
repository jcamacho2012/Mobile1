package com.example.mobile1

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistroPersonas() {
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }

    var names by remember {
        mutableStateOf(listOf<Person>())
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        TextField(value = name,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text("Name") },
            onValueChange = { text ->
                name = text
            })
        Spacer(modifier = Modifier.size(20.dp))

        TextField(value = age,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Age") },
            onValueChange = { text ->
                age = text
            })
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (name.isNotBlank() && age.isNotBlank()) {
                    val persona = Person(name,age.toInt())
                    names = names + persona
                    name = ""
                    age=""
                } else {
                    Toast.makeText(context, "Name and Age are mandatories", Toast.LENGTH_SHORT).show()
                }
            }) {
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = names) { currentName ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = currentName.name,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = currentName.age.toString(),
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
private fun RegisterPerson() {
    RegistroPersonas()
}