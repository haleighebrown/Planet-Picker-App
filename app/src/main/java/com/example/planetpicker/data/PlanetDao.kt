package com.example.planetpicker.data

import androidx.room.*
import com.example.planetpicker.model.Planet
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetDao {
    @Query("SELECT * FROM planet_database")
    fun getPlanets(): Flow<List<Planet>>

    @Query("SELECT * FROM planet_database WHERE id = :id")
    fun getPlanet(id: Int): Flow<Planet>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(planet: Planet)

    @Update
    fun update(planet: Planet)

    @Delete
    fun delete(planet: Planet)
}