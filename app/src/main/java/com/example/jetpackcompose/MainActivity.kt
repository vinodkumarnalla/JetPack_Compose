package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.fillMaxHeight()) {
                    SampleToolBar()
                    Greeting(name = "Android")
                    InputText(name = getString(R.string.app_name))
                    SimpleRecyclerView()
                    ComplexRecyclerView()

                }
            }

        }
    }

    /*Simple function to display text with padding and color*/
    @Composable
    fun Greeting(name: String) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(10.dp),
            style = TextStyle(color = Color.Red)
        )
    }

    /*Simple function to display edit text*/
    @Composable
    fun InputText(name: String) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(text = name) },
            maxLines = 2,
        )
    }

    /*Simple Recycler view*/
    @Composable
    fun SimpleRecyclerView() {
        val data = arrayOf("Item 1", "Item 2", "Item 3")
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(data.size) {
                Text(text = data[it])
            }
        }
    }


    /*Recyclerview with multiple views*/
    @Composable
    fun ComplexRecyclerView() {
        val data = arrayOf("Item 1", "Item 2", "Item 3")
        LazyColumn(modifier = Modifier.padding(5.dp)) {
            items(data.size) { count ->
                Row(modifier = Modifier.padding(5.dp)) {
                    val image = painterResource(R.drawable.dog)
                    Image(
                        painter = image,
                        contentDescription = "Sample",
                        modifier = Modifier
                            .requiredSize(48.dp)
                            .clip(CircleShape)

                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = ParagraphStyle(lineHeight = 20.sp)) {
                                withStyle(style = SpanStyle(color = Color.Blue)) {
                                    append("This is an example for JetPack compose recycler view\n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Red
                                    )
                                ) {
                                    append(data[count])
                                }
                            }
                        })
                }
                Divider()
            }
        }
    }

    /*Adding a toolbar using JetPack*/
    @Composable
    fun SampleToolBar() {
        TopAppBar(backgroundColor = Color.Red) {
            Row(modifier = Modifier.padding(5.dp)) {
                Text(text = getString(R.string.app_name))
            }
        }
    }

}