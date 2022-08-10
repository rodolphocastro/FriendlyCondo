package com.ardc.friendlycondo.infrastructure.logging

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
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
    @Reusable
    fun provideLogbackLogger(@ActivityContext context: Context?): Logger {
        return LoggerFactory.getLogger(context?.javaClass?.name ?: "FriendlyCondo")
    }
}