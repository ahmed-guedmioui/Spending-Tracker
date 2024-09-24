package com.ag_apps.spending_tracker.core.data

import com.ag_apps.spending_tracker.core.data.local.SpendingEntity
import com.ag_apps.spending_tracker.core.domain.Spending
import java.time.Instant
import java.time.ZoneId

/**
 * @author Ahmed Guedmioui
 */

fun SpendingEntity.toSpending(): Spending = Spending(
    spendingId = spendingId ?: 0,
    name = name,
    price = price,
    kilograms = kilograms,
    quantity = quantity,
    dateTimeUtc = Instant.parse(dateTimeUtc).atZone(ZoneId.of("UTC"))
)

fun Spending.toNewSpendingEntity(): SpendingEntity = SpendingEntity(
    name = name,
    price = price,
    kilograms = kilograms,
    quantity = quantity,
    dateTimeUtc = dateTimeUtc.toInstant().toString()
)

fun Spending.toEditedSpendingEntity(): SpendingEntity = SpendingEntity(
    spendingId = spendingId,
    name = name,
    price = price,
    kilograms = kilograms,
    quantity = quantity,
    dateTimeUtc = dateTimeUtc.toInstant().toString()
)
