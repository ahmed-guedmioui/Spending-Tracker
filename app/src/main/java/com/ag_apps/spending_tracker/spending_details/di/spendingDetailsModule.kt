package com.ag_apps.spending_tracker.spending_details.di

import com.ag_apps.spending_tracker.spending_details.domain.UpsertSpendingUseCase
import com.ag_apps.spending_tracker.spending_details.presentation.SpendingDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */

val spendingDetailsModule = module {
    single { UpsertSpendingUseCase(get()) }
    viewModel { SpendingDetailsViewModel(get()) }
}