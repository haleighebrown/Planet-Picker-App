package com.example.planetpicker.data

import com.example.planetpicker.R
import com.example.planetpicker.model.Planet

object DataSource {
    val planets = mapOf(
        "Mercury" to
                Planet(
                    stringResourceId = "Mercury",
                    imageResourceId = R.drawable.mercury,
                    cold = false,
                    gravity = false,
                    rocky = true,
                    rings = false,
                    moon = false,
                    details = "It's a planet!"
                ),
        "Venus" to
                Planet(
                    stringResourceId = "Venus",
                    imageResourceId = R.drawable.venus,
                    cold = false,
                    gravity = false,
                    rocky = true,
                    rings = false,
                    moon = false,
                    details = "It's a planet!"
                ),
        "Earth" to
                Planet(
                    stringResourceId = "Earth",
                    imageResourceId = R.drawable.earth,
                    cold = false,
                    gravity = false,
                    rocky = true,
                    rings = false,
                    moon = true,
                    details = "It's a planet!"
                ),
        "Mars" to
                Planet(
                    stringResourceId = "Mars",
                    imageResourceId = R.drawable.mars,
                    cold = true,
                    gravity = false,
                    rocky = true,
                    rings = true,
                    moon = true,
                    details = "It's a planet!"
                ),
        "Jupiter" to
                Planet(
                    stringResourceId = "Jupiter",
                    imageResourceId = R.drawable.jupiter,
                    cold = true,
                    gravity = true,
                    rocky = false,
                    rings = true,
                    moon = true,
                    details = "It's a planet!"
                ),
        "Saturn" to
                Planet(
                    stringResourceId = "Saturn",
                    imageResourceId = R.drawable.saturn,
                    cold = true,
                    gravity = true,
                    rocky = false,
                    rings = true,
                    moon = true,
                    details = "It's a planet!"
                ),
        "Uranus" to
                Planet(
                    stringResourceId = "Uranus",
                    imageResourceId = R.drawable.uranus,
                    cold = true,
                    gravity = false,
                    rocky = true,
                    rings = true,
                    moon = true,
                    details = "It's a planet!"
                ),
        "Neptune" to
                Planet(
                    stringResourceId = "Neptune",
                    imageResourceId = R.drawable.neptune,
                    cold = true,
                    gravity = true,
                    rocky = true,
                    rings = true,
                    moon = true,
                    details = "It's a planet!"
                )
    )
}

