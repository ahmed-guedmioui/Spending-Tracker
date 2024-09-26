package com.ag_apps.spending_tracker.spending_details.presentation

/**
 * @author Ahmed Guedmioui
 */
sealed interface SpendingDetailsAction {

    data class UpdateName(val newName: String): SpendingDetailsAction
    data class UpdatePrice(val newPrice: Double): SpendingDetailsAction
    data class UpdateKilograms(val newKilograms: Double): SpendingDetailsAction
    data class UpdateQuantity(val newQuantity: Double): SpendingDetailsAction

    data object SaveSpending: SpendingDetailsAction

}