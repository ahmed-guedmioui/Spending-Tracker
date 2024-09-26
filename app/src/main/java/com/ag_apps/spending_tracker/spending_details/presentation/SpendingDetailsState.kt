package com.ag_apps.spending_tracker.spending_details.presentation

/**
 * @author Ahmed Guedmioui
 */
data class SpendingDetailsState(
    val name: String = "",
    val price: Double = 0.0,
    val kilograms: Double = 0.0,
    val quantity: Double = 0.0,
)
