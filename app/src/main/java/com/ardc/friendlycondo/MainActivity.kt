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
import ch.qos.logback.classic.android.LogcatAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import com.ardc.friendlycondo.ui.theme.FriendlyCondoTheme
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * ## CrashylyticsAppender
 * Logback appender that forwards events to Firebase Crashlytics alongside logcat.
 */
class LogcatCrashlyticsAppender : LogcatAppender() {
    private var crashlyticsInstance: FirebaseCrashlytics = Firebase.crashlytics

    @Override
    override fun append(event: ILoggingEvent?) {
        super.append(event)
        event?.let {
            crashlyticsInstance.log(encoder.layout.doLayout(it))
        }
    }
}

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