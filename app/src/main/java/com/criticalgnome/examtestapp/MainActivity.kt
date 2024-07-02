package com.criticalgnome.examtestapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.criticalgnome.examtestapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val eventRepository: EventRepository = EventRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lastAppStart = LastAppStartManager.get(this)
        lifecycleScope.launch {
            val events = eventRepository.getAllEvents()  //TODO fix with getEventsFromAppStart(lastAppStart)
            val textData = events.map { it.timestamp }.joinToString(", ") // TODO stub
            binding.events.text = textData
        }
    }
}
