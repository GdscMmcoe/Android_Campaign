package com.birthdaygreeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.birthdaygreeting.ui.theme.BirthdayGreetingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayGreetingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage("Happy Birthday Om","Dinesh", modifier = Modifier)

                }
            }
        }
    }
}

@Composable
fun Greeting(msg: String, from:String, modifier: Modifier = Modifier) {

    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(5.dp))
    {

        Text(
            text = "$msg",
            fontSize = 100.sp,
            modifier = modifier,
            lineHeight = 116.sp,
            color = Color.Red,
            fontWeight = FontWeight(500)
        )
        Text(
            text = " - From $from ",
            fontSize = 36.sp,
            modifier = modifier.align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(msg: String, from: String, modifier: Modifier){

    Box {
        val image = painterResource(id = R.drawable.androidparty)

        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop, alpha = 0.6F)
        Greeting(msg, from)
    }


}

@Preview(showBackground = true, showSystemUi = true, name = "My Preview")
@Composable
fun GreetingPreview() {
    BirthdayGreetingTheme {
        GreetingImage("Happy Birthday Om","Dinesh", modifier = Modifier)
    }
}