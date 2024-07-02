package com.criticalgnome.examtestapp

import android.app.Application.MODE_PRIVATE
import android.content.Context
import java.util.Calendar

object LastAppStartManager {

    fun get(context: Context) : Long {
        return context.getSharedPreferences("last.start", MODE_PRIVATE).getLong("timestamp", 0)
    }
    fun set(context: Context, timestamp: Long) {
        context.getSharedPreferences("last.start", MODE_PRIVATE).edit().putLong("timestamp", Calendar.getInstance().timeInMillis).apply()
    }
}
