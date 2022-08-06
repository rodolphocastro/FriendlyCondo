package com.ardc.friendlycondo.features.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ardc.friendlycondo.AppCanvas

@Composable
fun LoginButton(state: LoginState, onButtonClicked: () -> Unit) {
    Button(
        onClick = onButtonClicked,
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
    ) {
        Icon(Icons.Filled.Person, contentDescription = "A person")
        Spacer(Modifier.width(16.dp))
        if (state.isLoggedIn) Text(text = "Continue") else Text(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoggedOffButton(): Unit {
    AppCanvas {
        Column {
            LoginButton(state = LoginState()) {
                /* do Nothing */
            }
        }
    }
}