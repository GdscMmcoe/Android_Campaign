package com.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var firstValue by remember { mutableStateOf<String?>(null) }
    var secondValue by remember { mutableStateOf<String?>(null) }

    var result by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
    ) {

//        First Input
        OutlinedTextField(
            value = firstValue ?:"",
            onValueChange = {
                firstValue = it
            },
            label = { Text("Enter first value") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

//        Space
        Spacer(modifier = Modifier.height(16.dp))

//        Second Input
        OutlinedTextField(
            value = secondValue ?: "",
            onValueChange = {
                secondValue = it
            },
            label = { Text("Enter second value") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            
//            Addition
            TextButton(
                onClick = {
                    result = (firstValue?.toFloatOrNull() ?: 0f) + (secondValue?.toFloatOrNull() ?: 0f)
                },
                modifier = Modifier
                    .padding(0.dp)
                    .border(
                    color = Color.Gray,
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                )


            ) {
                Text(text = "+",

                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Red
                    )
            }

            // substraction
            TextButton(
                onClick = {
                    result = (firstValue?.toFloatOrNull() ?: 0f) - (secondValue?.toFloatOrNull() ?: 0f)
                },
                modifier = Modifier

                    .padding(0.dp)
                    .border(
                        color = Color.Gray,
                        width = 2.dp,
                        shape = RoundedCornerShape(5.dp)
                    )


            ) {
                Text(text = "-",

                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Red
                )
            }

            // multiplication
            TextButton(
                onClick = {
                    result = (firstValue?.toFloatOrNull() ?: 0f) * (secondValue?.toFloatOrNull() ?: 0f)
                },
                modifier = Modifier
                    .padding(0.dp)
                    .border(
                        color = Color.Gray,
                        width = 2.dp,
                        shape = RoundedCornerShape(5.dp)
                    )


            ) {
                Text(text = "*",

                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Red
                )
            }


// division

 TextButton(
        onClick = {
            result = (firstValue?.toFloatOrNull() ?: 0f) / (secondValue?.toFloatOrNull() ?: 0f)
        },
            modifier = Modifier
                .padding(0.dp)
                .border(
                    color = Color.Gray,
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                )


            ) {
            Text(text = "/",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Red
            )
        }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Result: $result",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorAppPreview() {
//    CalculatorAppTheme {
       CalculatorApp()
//    }
}