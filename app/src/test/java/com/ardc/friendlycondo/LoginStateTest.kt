@file:Suppress("ClassName")

package com.ardc.friendlycondo

import com.ardc.friendlycondo.features.login.LoginState
import org.junit.Assert
import org.junit.Test

class `Given an User is Authorized` {
    private val subject = LoginState("anUser")

    @Test
    fun `Given an UserId is set, Then isLoggedIn should be true`() {
        // Arrange

        // Act

        // Assert
        subject.isLoggedIn.let {
            Assert.assertTrue(it)
        }
    }

    @Test
    fun `When I unauthorize, Then isLoggedIn should be false`(): Unit {
        // Arrange

        // Act
        val got = subject.unauthorize()

        // Assert
        got.isLoggedIn.let {
            Assert.assertFalse(it)
        }
    }
}


class `Given an User is not Authorized` {
    private val subject = LoginState()

    @Test
    fun `Given an UserId is not set, Then isLoggedIn should be false`(): Unit {
        // Arrange

        // Act

        // Assert
        subject.isLoggedIn.let {
            Assert.assertFalse(it)
        }
    }

    @Test
    fun `When I authorize with any userId, Then isLoggedIn should be true`(): Unit {
        // Arrange
        val anId = "pudim"

        // Act
        val got = subject.authorize(anId)

        // Assert
        got.isLoggedIn.let {
            Assert.assertTrue(it)
        }
    }

    @Test
    fun `When I authorize with an empty userId, Then an Exception is thrown`(): Unit {
        // Arrange

        // Act

        // Assert
        Assert.assertThrows(IllegalArgumentException::class.java) {
            subject.authorize("")
        }
    }
}