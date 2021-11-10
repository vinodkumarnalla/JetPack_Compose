package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : AppCompatActivity() {
    private val emailText = mutableStateOf(TextFieldValue())
    private val passwordText = mutableStateOf(TextFieldValue())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color.White)
                ) {
                    addTextField(emailText, "Email")
                    addTextField(passwordText, "Password")
                    addButton()
                }
            }
        }
    }

    @Composable
    private fun addTextField(text: MutableState<TextFieldValue>, label: String) {
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            label = { Text(text = label, style = TextStyle(Color.Black)) },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .fillMaxWidth()
        )
    }

    @Composable
    private fun addButton() {
        Button(
            onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .background(color = Color.Blue)
        ) {
            Text(text = "Login", style = TextStyle(color = Color.White, fontSize = 20.sp))
        }
    }
}