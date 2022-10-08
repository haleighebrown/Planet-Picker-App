package com.example.planetpicker.data

import android.graphics.Insets.add
import com.example.planetpicker.R
import kotlin.Comparable
import com.example.planetpicker.model.Planet

class Datasource {
    fun loadPlanet(cold: Boolean, gravity: Boolean, rocky: Boolean, rings: Boolean, moons: Boolean): MutableList<Planet> {
        val Planet = mutableListOf<Planet>()

        val planets = listOf(
            Planet(R.string.mercury, R.drawable.mercury, false, false, false, false, false),
            Planet(R.string.venus, R.drawable.venus, false, false, false, false, false),
            Planet(R.string.earth, R.drawable.earth, false, false, false, false, false),
            Planet(R.string.mars, R.drawable.mars, false, false, false, false, false),
            Planet(R.string.jupiter, R.drawable.jupiter, false, false, false, false, false),
            Planet(R.string.saturn, R.drawable.saturn, false, false, false, false, false),
            Planet(R.string.uranus, R.drawable.uranus, false, false, false, false, false),
            Planet(R.string.neptune, R.drawable.neptune, false, false, false, false, false)
        )

        for (plan in planets) {
            if (plan.cold == cold && plan.gravity == gravity && plan.rocky == rocky && plan.rings == rings && plan.moon == moons) {
                Planet += plan
            }


        }


        return Planet
    }
}