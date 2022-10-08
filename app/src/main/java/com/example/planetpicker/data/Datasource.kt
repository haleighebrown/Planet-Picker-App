package com.example.planetpicker.data

import android.graphics.Insets.add
import com.example.planetpicker.R
import kotlin.Comparable
import com.example.planetpicker.model.Planet

class Datasource {
    fun loadPlanet(cold: Boolean, gravity: Boolean, rocky: Boolean, rings: Boolean, moons: Boolean): MutableList<Planet> {
        val Planet = mutableListOf<Planet>()

        val planets = listOf(
            Planet(R.string.mercury, R.drawable.mercury, false, false, true, false, false),
            Planet(R.string.venus, R.drawable.venus, false, false, true, false, false),
            Planet(R.string.earth, R.drawable.earth, false, false, true, false, true),
            Planet(R.string.mars, R.drawable.mars, true, false, true, true, true),
            Planet(R.string.jupiter, R.drawable.jupiter, true, true, false, true, true),
            Planet(R.string.saturn, R.drawable.saturn, true, true, false, true, true),
            Planet(R.string.uranus, R.drawable.uranus, true, false, true, true, true),
            Planet(R.string.neptune, R.drawable.neptune, true, true, true, true, true)
        )

        for (plan in planets) {
            if (plan.cold == cold && plan.gravity == gravity && plan.rocky == rocky && plan.rings == rings && plan.moon == moons) {
                Planet += plan
            }


        }



        return Planet
    }
}