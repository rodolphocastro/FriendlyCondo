package com.ardc.friendlycondo

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented Tests for the Main Activity and related Components.
 */
class MainActivityInstrumentedTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun greetingContainsHello() {
        // Arrange
        // Starting the app
        composeRule.setContent {
            Greeting()
        }

        // Act
        // Nothing to do, just rendering

        // Assert
        composeRule
            .onNodeWithText("Welcome", ignoreCase = true, substring = true)
            .assertExists("Expected a Welcome Message, but found nothing")
    }
}