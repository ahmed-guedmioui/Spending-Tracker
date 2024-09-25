package com.ag_apps.spending_tracker.spending_overview.di

import com.ag_apps.spending_tracker.spending_overview.presentation.SpendingOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */
val spendingOverviewModule = module {
    viewModel { SpendingOverviewViewModel(get(), get()) }
}