package com.ag_apps.spending_tracker.spending_details.presentation

/**
 * @author Ahmed Guedmioui
 */
sealed interface SpendingDetailsEvent {

    data object SaveSuccess: SpendingDetailsEvent
    data object SaveFailed: SpendingDetailsEvent

}