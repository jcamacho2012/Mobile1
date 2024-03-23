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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import kotlinx.coroutines.delay


@Composable
fun FormTimer(
    duration: Int,
    onPause: () -> Unit = {},
    onReset: () -> Unit = {},
    onComplete: () -> Unit = {}
) {

    var timeLeft by remember {
        mutableIntStateOf(duration)
    }

    var isPaused by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft == 0) onComplete()
        while (timeLeft > 0 && !isPaused) {
            delay(1000L)
            timeLeft--

        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Time Left: ${timeLeft}",
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp
        )
        Column(
            modifier = Modifier.padding(16.dp),

            ) {
            Button(
                onClick = {
                    onReset()
                    timeLeft = duration
                    isPaused = false
                }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Default.Refresh, contentDescription = null
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "Reload")
            }
            Button(
                onClick = {
                    isPaused = true
                    onPause()
                }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Default.Clear, contentDescription = null
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "Pause")
            }
        }
    }
}

@Composable
fun RegistrationForm(
    addPerson: (Person) -> Unit,
    isFormEnabled: Boolean
) {
    Column {
        var name by remember {
            mutableStateOf("")
        }

        var age by remember {
            mutableStateOf("")
        }
        val context = LocalContext.current

        TextField(value = name,
            enabled = isFormEnabled,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text("Name") },
            onValueChange = { text ->
                name = text
            })
        Spacer(modifier = Modifier.size(20.dp))

        TextField(value = age,
            enabled = isFormEnabled,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Age") },
            onValueChange = { text ->
                age = text
            })
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = isFormEnabled,
            onClick = {
                if (name.isNotBlank() && age.isNotBlank()) {
                    val persona = Person(name, age.toInt())
                    addPerson(persona)
                    name = ""
                    age = ""
                } else {
                    Toast.makeText(context, "Name and Age are mandatories", Toast.LENGTH_SHORT)
                        .show()
                }
            }) {
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Register")
        }
    }
}

@Composable
fun RegistroPersonas() {
    var isFormEnabled by remember {
        mutableStateOf(true)
    }

    var duration by remember {
        mutableIntStateOf(10)
    }

    var personList by remember {
        mutableStateOf(listOf<Person>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        FormTimer(
            duration = duration,
            onComplete = {
                isFormEnabled = false
            },
            onReset = {
                isFormEnabled = true
                duration = 10
            }
        )
        RegistrationForm(
            isFormEnabled = isFormEnabled,
            addPerson = { capturePerson ->
                personList += capturePerson
            }
        )
        Spacer(modifier = Modifier.size(20.dp))
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = personList) { currentName ->
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