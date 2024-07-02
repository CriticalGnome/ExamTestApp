package com.criticalgnome.examtestapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class BootReceiver : BroadcastReceiver() {

    private val eventRepository = EventRepositoryImpl()

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                CoroutineScope(Dispatchers.IO).launch {
                    eventRepository.addEvent(BootEvent(0, Calendar.getInstance().timeInMillis, false))
                }
            }
        }
    }
}
