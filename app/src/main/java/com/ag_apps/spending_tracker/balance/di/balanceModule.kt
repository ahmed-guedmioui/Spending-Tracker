package com.ag_apps.spending_tracker.balance.di

import com.ag_apps.spending_tracker.balance.presentation.BalanceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */

val balanceModule = module {
    viewModel { BalanceViewModel(get()) }
}