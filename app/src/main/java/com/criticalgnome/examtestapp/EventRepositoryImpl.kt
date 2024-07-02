package com.criticalgnome.examtestapp

class EventRepositoryImpl : EventRepository {

    private val eventDao = EventsDatabase.database.bootEventDao()

    override suspend fun getAllEvents() = eventDao.getAllEvents()

    override suspend fun getNewEvents() = eventDao.getNewEvents()

    override suspend fun getEventsFromAppStart(timestamp: Long) = eventDao.getEventsFromTimestamp(timestamp)

    override suspend fun addEvent(event: BootEvent) = eventDao.addEvent(event)

    override suspend fun updateEvent(event: BootEvent) = eventDao.updateEvent(event)

    override suspend fun deleteEvent(id: Int) = eventDao.deleteById(id)

    override suspend fun deleteEvent(event: BootEvent) = eventDao.delete(event)

}
