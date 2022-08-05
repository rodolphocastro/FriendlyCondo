package com.ardc.friendlycondo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ardc.friendlycondo.ui.theme.FriendlyCondoTheme
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MainActivity : ComponentActivity() {
    private lateinit var log: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        log = LoggerFactory.getLogger(MainActivity::class.java)
        log.debug("Initializing...")
        super.onCreate(savedInstanceState)
        setContent {
            FriendlyCondoTheme {
                // A surface container using the 'background' color from the theme
                AppCanvas {
                    Greeting(log)
                }
            }
        }
    }

}

/**
 * ## AppCanvas
 * A simple 'canvas' that can be reuse to provide an unified "look and feel" to the App.
 */
@Composable
fun AppCanvas(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        content()
    }
}

/**
 * ## Greeting
 * A simple "hero" to welcome users into the application
 */
@Composable
fun Greeting(log: Logger? = null) {
    log?.debug("greeting!")
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_undraw_deliveries),
            contentDescription = "People standing around with packages"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
        )

        Text(
            text = "Welcome to FriendlyCondo!",
            modifier = Modifier
                .padding(5.dp, 0.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FriendlyCondoTheme {
        AppCanvas {
            Greeting()
        }
    }
}