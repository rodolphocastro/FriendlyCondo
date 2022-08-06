package com.ardc.friendlycondo.features.login

/**
 * ## LoginState
 * This class represents the Login (Authentication) state for the application and its components.
 * @param userId The user's unique identifier.
 */
data class LoginState(val userId: String = "") {

    /**
     * Returns whenever an user is currently authenticated or not.
     */
    val isLoggedIn: Boolean
        get() = !userId.isNullOrBlank()

    /**
     * Authorizes an user by storing its identifier.
     */
    fun authorize(authorizedId: String): LoginState {
        if (authorizedId.isNullOrBlank()) throw IllegalArgumentException("Cannot authorize an empty user!")
        return copy(userId = authorizedId)
    }

    /**
     * Unauthorizes an user by removing its identifier.
     */
    fun unauthorize(): LoginState {
        return copy(userId = "")
    }
}