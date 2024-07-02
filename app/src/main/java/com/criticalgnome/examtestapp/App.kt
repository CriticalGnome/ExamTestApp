package com.criticalgnome.examtestapp

import android.app.Application
import java.util.Calendar

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        getSharedPreferences("last.start", MODE_PRIVATE).edit().putLong("timestamp", Calendar.getInstance().timeInMillis).apply()
        EventsDatabase.initDatabase(this)
        NotificationRepeater.setup(this)
    }
}
