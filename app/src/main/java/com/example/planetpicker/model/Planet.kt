package com.example.planetpicker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planet_database")
data class Planet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "stringResourceId")
    val stringResourceId: String,
    @ColumnInfo(name = "imageResourceId")
    val imageResourceId: Int,
    @ColumnInfo(name = "cold")
    val cold: Boolean,
    @ColumnInfo(name = "gravity")
    val gravity: Boolean,
    @ColumnInfo(name = "rocky")
    val rocky: Boolean,
    @ColumnInfo(name = "rings")
    val rings: Boolean,
    @ColumnInfo(name = "moon")
    val moon: Boolean,
    @ColumnInfo(name = "details")
    val details: String){

}
