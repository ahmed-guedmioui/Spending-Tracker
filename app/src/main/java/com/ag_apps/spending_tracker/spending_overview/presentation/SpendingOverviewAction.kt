package com.ag_apps.spending_tracker.spending_overview.presentation

/**
 * @author Ahmed Guedmioui
 */
sealed interface SpendingOverviewAction {
    data object LoadSpendingOverviewAndBalance: SpendingOverviewAction
    data class OnDateChange(val newDate: Int): SpendingOverviewAction
    data class OnDeleteSpending(val spendingId: Int): SpendingOverviewAction
}