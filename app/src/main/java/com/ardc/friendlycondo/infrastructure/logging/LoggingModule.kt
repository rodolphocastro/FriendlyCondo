package com.ardc.friendlycondo.infrastructure.logging

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * HILT Module for logging components.
 */
@Module
@InstallIn(ActivityComponent::class)
object LoggingModule {

    /**
     * Provides a Logger built from the logging configurations.
     */
    @Provides
    fun provideLogbackLogger(): Logger {
        return LoggerFactory.getLogger("FriendlyCondo")
    }
}