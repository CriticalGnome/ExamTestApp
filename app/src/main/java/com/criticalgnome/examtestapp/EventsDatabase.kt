package com.criticalgnome.examtestapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BootEvent::class], version = 1)
abstract class EventsDatabase : RoomDatabase() {

    abstract fun bootEventDao(): BootEventDao

    companion object {
        lateinit var database: EventsDatabase
        fun initDatabase(context: Context) {
            database = Room.databaseBuilder(
                context = context,
                klass = EventsDatabase::class.java,
                name = "events.db"
            ).build()
        }
    }
}
