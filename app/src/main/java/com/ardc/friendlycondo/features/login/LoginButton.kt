package com.ardc.friendlycondo.features.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ardc.friendlycondo.AppCanvas

/**
 * ## LoginButton
 * Allows an user to log into the application.
 * @param state current state of login within the App
 * @param onButtonClicked delegate to execute when the button is clicked
 */
@Composable
fun LoginButton(
    state: LoginState,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = onButtonClicked,
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
    ) {
        if (state.isLoggedIn)
            Icon(Icons.Filled.ArrowForward, contentDescription = "A person")
        else Icon(
            Icons.Filled.Person,
            contentDescription = "A person"
        )

        Spacer(Modifier.width(16.dp))

        if (state.isLoggedIn)
            Text(text = "Continue")
        else Text(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    AppCanvas {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            LoginButton(state = LoginState()) {
                /* do nothing */
            }
            LoginButton(state = LoginState("anuser")) {
                /* do nothing */
            }
        }
    }
}