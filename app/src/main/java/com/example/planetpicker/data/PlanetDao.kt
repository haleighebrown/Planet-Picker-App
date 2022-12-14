package com.example.planetpicker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetDao {
    @Query("SELECT * FROM planet")
    fun getPlanets(): Flow<List<Planet>>

    @Query("SELECT * FROM planet WHERE id = :id")
    fun getPlanet(id: Int): Flow<Planet>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(planet: Planet)

    @Update
    suspend fun update(planet: Planet)

    @Delete
    suspend fun delete(planet: Planet)
}