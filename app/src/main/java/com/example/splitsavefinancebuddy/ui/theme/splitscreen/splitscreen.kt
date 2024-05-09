package com.example.splitsavefinancebuddy.ui.theme.splitscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.splitsavefinancebuddy.R
import java.util.Scanner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*


@Composable
fun SplitScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.splitscreen),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds, modifier = Modifier.matchParentSize()
        )
        var num1 by remember { mutableStateOf(0f) }
        var num2 by remember { mutableStateOf(0f) }
        var result by remember { mutableStateOf(0f) }


            Column(modifier = Modifier.padding(16.dp)) {
                DivisionTextField("Total Bill", num1) { num1 = it }
                DivisionTextField("Number of people", num2) { num2 = it }
                Button(onClick = {
                    if (num2 != 0f) {
                        result = num1    / num2
                    } else {
                        result = Float.NaN
                    }
                }) {
                    if (result.isNaN()) {
                        "Cannot divide by zero"
                    } else {
                        "Divide"
                    }
                }
                if (!result.isNaN()) {
                    ResultText(result)
                }
            }
        }
    }

    @Composable
    fun DivisionTextField(label: String, value: Float, onValueChange: (Float) -> Unit) {
        var textValue by remember { mutableStateOf(TextFieldValue(value.toString())) }

        TextField(
            value = textValue,
            onValueChange = {
                textValue = it
                onValueChange(it.text.toFloatOrNull() ?: 0f)
            },
            label = { Text(label) }
        )
    }

    @Composable
    fun ResultText(result: Float) {
        Text("Result: $result")
    }
@Preview
@Composable
fun SplitScreenPreview(){
    SplitScreen(rememberNavController())
}