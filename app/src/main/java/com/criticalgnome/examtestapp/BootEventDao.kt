package com.criticalgnome.examtestapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface BootEventDao {

    @Query("SELECT * FROM events")
    suspend fun getAllEvents(): List<BootEvent>

    @Query("SELECT * FROM events WHERE shown = 0")
    suspend fun getNewEvents(): List<BootEvent>

    @Query("SELECT * FROM events WHERE timestamp > :timestamp")
    suspend fun getEventsFromTimestamp(timestamp: Long): List<BootEvent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(vararg event: BootEvent)

    @Update
    suspend fun updateEvent(vararg event: BootEvent)

    @Query("DELETE FROM events WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Delete
    fun delete(event: BootEvent)
}
