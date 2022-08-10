@file:Suppress("ClassName")

package com.ardc.friendlycondo.infrastructure.logging

import org.junit.Assert
import org.junit.Test

class `Given no Application Context` {

    @Test
    fun `When A Logger is Request, Then a Logger is returned`() {
        // Arrange

        // Act
        val got = LoggingModule.provideLogbackLogger()

        // Assert
        got.let {
            Assert.assertNotNull(got)
        }
    }
}