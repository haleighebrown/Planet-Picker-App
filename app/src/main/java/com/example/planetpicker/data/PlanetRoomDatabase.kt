package com.example.planetpicker.data

import android.content.ClipData
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.planetpicker.model.Planet


@Database(entities = [Planet::class], version = 1, exportSchema = false)
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
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}