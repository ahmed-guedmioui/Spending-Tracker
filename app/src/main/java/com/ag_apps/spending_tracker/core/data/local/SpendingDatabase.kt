package com.ag_apps.spending_tracker.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Ahmed Guedmioui
 */

@Database(
    entities = [SpendingEntity::class],
    version = 1
)
abstract class SpendingDatabase: RoomDatabase() {
    abstract val dao: SpendingDao
}