package com.ag_apps.spending_tracker.core.data.local

import android.content.SharedPreferences
import com.ag_apps.spending_tracker.core.domain.CoreRepository

/**
 * @author Ahmed Guedmioui
 */
class CoreRepositoryImpl(
    private val prefs: SharedPreferences
) : CoreRepository {

    override suspend fun updateBalance(balance: Double) {
        prefs.edit().putFloat(KEY_BALANCE, balance.toFloat()).apply()
    }

    override suspend fun getBalance(): Double {
        return prefs.getFloat(KEY_BALANCE, 0f).toDouble()
    }

    companion object {
        private const val KEY_BALANCE = "KEY_BALANCE"
    }
}