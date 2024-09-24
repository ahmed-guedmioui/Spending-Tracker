package com.ag_apps.spending_tracker.balance.presentation

/**
 * @author Ahmed Guedmioui
 */
sealed interface BalanceAction {
    data class OnBalanceChanged(
        val newBalance: Double
    ) : BalanceAction

    data object OnBalanceSaved : BalanceAction
}