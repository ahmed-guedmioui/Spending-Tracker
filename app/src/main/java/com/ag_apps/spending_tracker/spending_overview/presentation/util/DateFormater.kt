package com.ag_apps.spending_tracker.spending_overview.presentation.util

import java.time.ZonedDateTime

/**
 * @author Ahmed Guedmioui
 */


fun ZonedDateTime.formatDate(): String {
    return "$dayOfMonth-$monthValue-$year"
}