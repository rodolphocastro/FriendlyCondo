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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ardc.friendlycondo.features.login.LoginButton
import com.ardc.friendlycondo.features.login.LoginState
import com.ardc.friendlycondo.ui.theme.FriendlyCondoTheme
import dagger.hilt.android.AndroidEntryPoint
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var log: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        log = LoggerFactory.getLogger(MainActivity::class.java)
        log.debug("Initializing...")
        super.onCreate(savedInstanceState)
        setContent {
            AppCanvas {
                Greeting(log)
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
    FriendlyCondoTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            content()
        }
    }
}

/**
 * ## Greeting
 * A simple "hero" to welcome users into the application
 */
@Composable
fun Greeting(log: Logger? = null) {
    var loginState by remember {
        mutableStateOf(LoginState())
    }
    log?.debug("greeting!")
    Column(verticalArrangement = Arrangement.spacedBy(16.dp))
    {
        Image(
            painter = painterResource(id = R.drawable.ic_undraw_deliveries),
            contentDescription = "People standing around with packages"
        )

        Text(
            text = "Welcome to FriendlyCondo!",
            modifier = Modifier
                .padding(5.dp, 0.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(64.dp))

        LoginButton(state = loginState) {
            loginState =
                if (loginState.isLoggedIn)
                    loginState.unauthorize()
                else loginState.authorize("temp-user")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppCanvas {
        Greeting()
    }
}