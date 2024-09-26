package com.ag_apps.spending_tracker.spending_overview.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ag_apps.spending_tracker.core.domain.CoreRepository
import com.ag_apps.spending_tracker.core.domain.LocalSpendingDataSource
import com.ag_apps.spending_tracker.core.domain.Spending
import com.ag_apps.spending_tracker.spending_overview.presentation.util.randomColor
import kotlinx.coroutines.launch
import java.time.ZonedDateTime

/**
 * @author Ahmed Guedmioui
 */
class SpendingOverviewViewModel(
    private val spendingDataSource: LocalSpendingDataSource,
    private val coreRepository: CoreRepository
) : ViewModel() {

    var state by mutableStateOf(SpendingOverviewState())
        private set

    fun onAction(action: SpendingOverviewAction) {
        when (action) {
            SpendingOverviewAction.LoadSpendingOverviewAndBalance -> {
                loadSpendingListAndBalance()
            }

            is SpendingOverviewAction.OnDateChange -> {
                val newDate = state.dateList[action.newDate]
                viewModelScope.launch {
                    state = state.copy(
                        pickedDate = newDate,
                        spendingList = getSpendingListByDate(newDate)
                    )
                }
            }

            is SpendingOverviewAction.OnDeleteSpending -> {
                viewModelScope.launch {
                    spendingDataSource.deleteSpending(action.spendingId)
                    state = state.copy(
                        spendingList = getSpendingListByDate(state.pickedDate),
                        dateList = spendingDataSource.getAllDates(),
                        balance = coreRepository.getBalance() - spendingDataSource.getSpendBalance(),
                    )
                }
            }
        }
    }

    private fun loadSpendingListAndBalance() {
        viewModelScope.launch {
            println("loadSpendingListAndBalance: ${coreRepository.getBalance()}")
            val allDates = spendingDataSource.getAllDates()

            state = state.copy(
                spendingList = getSpendingListByDate(
                    allDates.lastOrNull() ?: ZonedDateTime.now()
                ),
                balance = coreRepository.getBalance() - spendingDataSource.getSpendBalance(),
                pickedDate = allDates.lastOrNull() ?: ZonedDateTime.now(),
                dateList = allDates.reversed()
            )


        }
    }

    private suspend fun getSpendingListByDate(date: ZonedDateTime): List<Spending> {
        return spendingDataSource
            .getSpendingsByDate(date)
            .reversed()
            .map { it.copy(color = randomColor()) }
    }

}