package com.mapbox.navigation.core.telemetry.events

import android.annotation.SuppressLint
import com.mapbox.navigation.base.metrics.NavigationMetrics

@SuppressLint("ParcelCreator")
internal class NavigationFreeDriveEvent(
    phoneState: PhoneState
) : NavigationEvent(phoneState) {

    /*
     * Don't remove any fields, cause they are should match with
     * the schema downloaded from S3. Look at {@link SchemaTest}
     */
    var eventType: FreeDriveEventType? = null
    var location: TelemetryLocation? = null

    override fun getEventName(): String = NavigationMetrics.FREE_DRIVE
}

internal enum class FreeDriveEventType(val type: String) {
    START("start"),
    STOP("stop")
}
