package com.ardc.friendlycondo.features.login

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class LoginComponentsTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun givenNoLoggedUserThenShowsLoginText() {
        // Arrange
        val state = LoginState()

        // Act
        composeRule.setContent {
            LoginButton(state) { TODO() }
        }

        // Assert
        composeRule
            .onNodeWithText("Login", substring = true, ignoreCase = true)
            .assertExists()
    }

    @Test
    fun givenNoLoggedUserThenClickingExecutes() {
        // Arrange
        val state = LoginState()
        var clicked = false

        // Act
        composeRule.setContent {
            LoginButton(state) { clicked = true }
        }

        // Assert
        composeRule
            .onNodeWithText("Login", substring = true, ignoreCase = true)
            .assertHasClickAction()
            .performClick()
        clicked.let {
            Assert.assertTrue(it)
        }
    }
}