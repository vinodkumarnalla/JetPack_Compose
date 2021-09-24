package com.example.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
             MaterialTheme() {
                 Column(modifier = Modifier.fillMaxHeight()) {
                     Greeting(name = "Android")
                     InputText(name = getString(R.string.app_name))
                     AddRecyclerView()
                 }
             }

        }
    }

    /*Simple function to display text with padding and color*/
    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.padding(10.dp),style = TextStyle(color = Color.Red))
    }

    /*Simple function to display edit text*/
    @Composable
    fun InputText(name: String) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(text = name)}
        )
    }

    /*Simple Recycler view*/
    @Composable
    fun AddRecyclerView(){
        val data = arrayOf("Item 1","Item 2","Item 3") 
        LazyColumn(modifier = Modifier.padding(10.dp)){
            items(data.size){
                    Text(text = data[it])
            }
        }
    }
}