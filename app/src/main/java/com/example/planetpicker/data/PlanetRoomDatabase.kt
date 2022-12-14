package com.example.planetpicker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Planet::class], version = 2, exportSchema = false)
abstract class PlanetRoomDatabase : RoomDatabase() {

    abstract fun planetDao(): PlanetDao

    companion object {
        @Volatile
        private var INSTANCE: PlanetRoomDatabase? = null
        fun getDatabase(context: Context): PlanetRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlanetRoomDatabase::class.java,
                    "planet_database"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}