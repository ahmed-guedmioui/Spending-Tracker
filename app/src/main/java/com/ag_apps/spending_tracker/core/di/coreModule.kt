package com.ag_apps.spending_tracker.core.di

import android.content.Context
import androidx.room.Room
import com.ag_apps.spending_tracker.core.data.RoomSpendingDataSource
import com.ag_apps.spending_tracker.core.data.local.CoreRepositoryImpl
import com.ag_apps.spending_tracker.core.data.local.SpendingDatabase
import com.ag_apps.spending_tracker.core.domain.CoreRepository
import com.ag_apps.spending_tracker.core.domain.LocalSpendingDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Ahmed Guedmioui
 */

val coreModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            SpendingDatabase::class.java,
            "spending_database_db"
        ).build()
    }

    single { get<SpendingDatabase>().dao }

    single {
        androidApplication().getSharedPreferences(
            "spending_tracker_preferences", Context.MODE_PRIVATE
        )
    }

    singleOf(::RoomSpendingDataSource).bind<LocalSpendingDataSource>()
    singleOf(::CoreRepositoryImpl).bind<CoreRepository>()
}