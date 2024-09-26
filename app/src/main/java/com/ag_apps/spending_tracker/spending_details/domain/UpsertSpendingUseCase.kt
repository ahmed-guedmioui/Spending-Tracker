package com.ag_apps.spending_tracker.spending_details.domain

import com.ag_apps.spending_tracker.core.domain.LocalSpendingDataSource
import com.ag_apps.spending_tracker.core.domain.Spending

/**
 * @author Ahmed Guedmioui
 */
class UpsertSpendingUseCase(
    private val spendingDataSource: LocalSpendingDataSource
) {

    suspend operator fun invoke(spending: Spending): Boolean {

        if (spending.name.isBlank()) {
            return false
        }
        if (spending.price < 0) {
            return false
        }
        if (spending.kilograms < 0) {
            return false
        }
        if (spending.quantity < 0) {
            return false
        }

        spendingDataSource.upsertSpending(spending)
        return true
    }

}