package com.ardc.friendlycondo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ardc.friendlycondo.ui.theme.FriendlyCondoTheme
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class MainActivity : ComponentActivity() {
    private lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        logger = LoggerFactory.getLogger(MainActivity::class.java)
        logger.info("Hello, world")
        super.onCreate(savedInstanceState)
        setContent {
            FriendlyCondoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Button(onClick = { crashWithText("Testing Crashlytics", logger) }) {
                        Greeting("Android")
                    }
                }
            }
        }
    }
}

private fun crashWithText(message: String, logger: Logger): Unit {
    logger.warn("Something is wrong, I can feel it!")
    throw RuntimeException(message)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FriendlyCondoTheme {
        Greeting("Android")
    }
}