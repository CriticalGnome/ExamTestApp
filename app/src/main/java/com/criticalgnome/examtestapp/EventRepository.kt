package com.criticalgnome.examtestapp

interface EventRepository {
    suspend fun getAllEvents(): List<BootEvent>
    suspend fun getNewEvents(): List<BootEvent>
    suspend fun getEventsFromAppStart(timestamp: Long): List<BootEvent>
    suspend fun addEvent(event: BootEvent)
    suspend fun updateEvent(event: BootEvent)
    suspend fun deleteEvent(id: Int)
    suspend fun deleteEvent(event: BootEvent)
}
