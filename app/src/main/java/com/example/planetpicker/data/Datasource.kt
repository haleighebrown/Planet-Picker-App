package com.example.planetpicker.data

import com.example.planetpicker.R
import com.example.planetpicker.model.Planet

class Datasource {
    fun loadPlanet(): List<Planet> {
        return listOf<Planet>(
            Planet(R.string.mercury, R.drawable.mercury),
            Planet(R.string.venus, R.drawable.venus),
            Planet(R.string.earth, R.drawable.earth),
            Planet(R.string.mars, R.drawable.mars),
            Planet(R.string.jupiter, R.drawable.jupiter),
            Planet(R.string.saturn, R.drawable.saturn),
            Planet(R.string.uranus, R.drawable.uranus),
            Planet(R.string.neptune, R.drawable.neptune),
        )
    }
}