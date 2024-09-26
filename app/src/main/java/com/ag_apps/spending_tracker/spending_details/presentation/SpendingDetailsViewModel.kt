package com.ag_apps.spending_tracker.spending_details.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ag_apps.spending_tracker.core.domain.Spending
import com.ag_apps.spending_tracker.spending_details.domain.UpsertSpendingUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.ZonedDateTime

/**
 * @author Ahmed Guedmioui
 */
class SpendingDetailsViewModel(
    private val upsertSpendingUseCase: UpsertSpendingUseCase
) : ViewModel() {

    var state by mutableStateOf(SpendingDetailsState())
        private set

    private val _eventChannel = Channel<SpendingDetailsEvent>()
    val event = _eventChannel.receiveAsFlow()

    fun onAction(action: SpendingDetailsAction) {
        when (action) {
            is SpendingDetailsAction.UpdateKilograms -> {
                state = state.copy(
                    kilograms = action.newKilograms
                )
            }

            is SpendingDetailsAction.UpdateName -> {
                state = state.copy(
                    name = action.newName
                )
            }

            is SpendingDetailsAction.UpdatePrice -> {
                state = state.copy(
                    price = action.newPrice
                )
            }

            is SpendingDetailsAction.UpdateQuantity -> {
                state = state.copy(
                    quantity = action.newQuantity
                )
            }

            SpendingDetailsAction.SaveSpending -> {
                viewModelScope.launch {
                    if (saveSpending()) {
                        _eventChannel.send(SpendingDetailsEvent.SaveSuccess)
                    } else {
                        _eventChannel.send(SpendingDetailsEvent.SaveFailed)
                    }
                }
            }
        }
    }

    private suspend fun saveSpending(): Boolean {
        val spending = Spending(
            spendingId = null,
            name = state.name,
            price = state.price,
            kilograms = state.kilograms,
            quantity = state.quantity,
            dateTimeUtc = ZonedDateTime.now()
        )

        return upsertSpendingUseCase(spending)
    }

}