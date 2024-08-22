package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycalculator.ui.theme.MyCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator(){

    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

        var firstInput by remember {
            mutableStateOf<String?>(null)
        }

        var secondInput by remember {
            mutableStateOf<String?>(null)
        }

        var result by remember {
mutableStateOf(0f)
        }

        // First Inputbox
        OutlinedTextField(value = firstInput ?:""  , onValueChange = {
            firstInput = it
        },
            label = {Text(text = "Enter first Input")}

        )

        // Second Inputbox
        OutlinedTextField(value = secondInput ?:""  , onValueChange = {
            secondInput = it
        },
            label = {Text(text = "Enter Second Input")}

        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
           ){

            // For Addition
            TextButton(onClick = {
                                 result = (firstInput?.toFloatOrNull() ?: 0f ) +( secondInput?.toFloatOrNull() ?: 0f )

            }, modifier = Modifier
                .padding(0.dp)
                .border(
                    color = Color.Gray,
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                )) {
                
                Text(text = "+", style = MaterialTheme.typography.headlineMedium, color = Color.Red)
            }

            // For Substraction
            TextButton(onClick = {
                result = (firstInput?.toFloatOrNull() ?: 0f )  - ( secondInput?.toFloatOrNull() ?: 0f )

            }, modifier = Modifier
                .padding(0.dp)
                .border(
                    color = Color.Gray,
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                )) {

                Text(text = "-", style = MaterialTheme.typography.headlineMedium, color = Color.Red)
            }

            // For Multiplication
            TextButton(onClick = {
                result = (firstInput?.toFloatOrNull() ?: 0f ) +( secondInput?.toFloatOrNull() ?: 0f )

            }, modifier = Modifier
                .padding(0.dp)
                .border(
                    color = Color.Gray,
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                )) {

                Text(text = "X", style = MaterialTheme.typography.headlineMedium, color = Color.Red)
            }

            // For Division
            TextButton(onClick = {
                result = (firstInput?.toFloatOrNull() ?: 0f ) / ( secondInput?.toFloatOrNull() ?: 0f )

            }, modifier = Modifier
                .padding(0.dp)
                .border(
                    color = Color.Gray,
                    width = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                )) {

                Text(text = "/", style = MaterialTheme.typography.headlineMedium, color = Color.Red)
            }

        }
        Text(text = "Result = $result", style = MaterialTheme.typography.headlineMedium)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorAppPreview() {
    MyCalculatorTheme {
        Calculator()
    }
}