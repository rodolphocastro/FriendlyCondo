package com.ardc.friendlycondo.infrastructure.logging

import ch.qos.logback.classic.android.LogcatAppender
import ch.qos.logback.classic.spi.ILoggingEvent
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

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