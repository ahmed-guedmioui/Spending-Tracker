package com.ag_apps.spending_tracker.core.domain

import java.time.ZonedDateTime

/**
 * @author Ahmed Guedmioui
 */
interface LocalSpendingDataSource {

    suspend fun getAllSpendings(): List<Spending>

    suspend fun getSpendingsByDate(
        dateTimeUtc: ZonedDateTime
    ): List<Spending>

    suspend fun getAllDates(): List<ZonedDateTime>

    suspend fun getSpending(id: Int): Spending

    suspend fun upsertSpending(spending: Spending)

    suspend fun getSpendBalance(): Double

    suspend fun deleteSpending(id: Int)

}