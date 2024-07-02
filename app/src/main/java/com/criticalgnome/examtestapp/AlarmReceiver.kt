package com.criticalgnome.examtestapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class AlarmReceiver: BroadcastReceiver() {

    private val eventRepository = EventRepositoryImpl()

    override fun onReceive(context: Context?, intent: Intent?) {
        CoroutineScope(Dispatchers.IO).launch {
            val events = eventRepository.getNewEvents()
            when  {
                events.isEmpty() -> showNotification(context,"No boots detected")
                events.size == 1 -> {
                    val dateText = getDateString(events.first().timestamp)
                    showNotification(context,"The boot was detected = $dateText")
                }
                else -> {
                    val delta = events[0].timestamp - events[1].timestamp
                    showNotification(context, "Last boots time delta = $delta millisecond")
                }
            }
        }
    }

    private fun showNotification(context: Context?, text: String) {
        context?.let {
            NotificationCompat.Builder(it, "MainChannel")
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        }
    }

    private fun getDateString(timestamp: Long) : String {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        return simpleDateFormat.format(timestamp)
    }
}
