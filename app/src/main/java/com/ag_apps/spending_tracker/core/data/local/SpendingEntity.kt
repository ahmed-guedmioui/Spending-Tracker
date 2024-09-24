package com.ag_apps.spending_tracker.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Ahmed Guedmioui
 */
@Entity
data class SpendingEntity(

    @PrimaryKey(autoGenerate = true)
    val spendingId: Int? = null,

    val name: String,
    val price: Double,
    val kilograms: Double,
    val quantity: Double,
    val dateTimeUtc: String
)
