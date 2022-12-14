package com.example.planetpicker

import android.app.Application
import com.example.planetpicker.data.PlanetRoomDatabase

class PlanetPickerApplication : Application(){
    val database: PlanetRoomDatabase by lazy { PlanetRoomDatabase.getDatabase(this) }
}