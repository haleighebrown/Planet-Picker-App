package com.example.planetpicker.data

import android.content.res.Resources
import com.example.planetpicker.R
import com.example.planetpicker.model.Planet

object PlanetsData{
    fun getPlanetsData(): ArrayList<Planet> {

        return arrayListOf(
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.mercury),
                    imageResourceId = R.drawable.mercury,
                    cold = false,
                    gravity = false,
                    rocky = true,
                    rings = false,
                    moon = false,
                    details = Resources.getSystem().getString(R.string.mercury_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.venus),
                    imageResourceId = R.drawable.venus,
                    cold = false,
                    gravity = false,
                    rocky = true,
                    rings = false,
                    moon = false,
                    details = Resources.getSystem().getString(R.string.venus_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.earth),
                    imageResourceId = R.drawable.earth,
                    cold = false,
                    gravity = false,
                    rocky = true,
                    rings = false,
                    moon = true,
                    details = Resources.getSystem().getString(R.string.earth_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.mars),
                    imageResourceId = R.drawable.mars,
                    cold = true,
                    gravity = false,
                    rocky = true,
                    rings = true,
                    moon = true,
                    details = Resources.getSystem().getString(R.string.mars_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.jupiter),
                    imageResourceId = R.drawable.jupiter,
                    cold = true,
                    gravity = true,
                    rocky = false,
                    rings = true,
                    moon = true,
                    details = Resources.getSystem().getString(R.string.jupiter_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.saturn),
                    imageResourceId = R.drawable.saturn,
                    cold = true,
                    gravity = true,
                    rocky = false,
                    rings = true,
                    moon = true,
                    details = Resources.getSystem().getString(R.string.saturn_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.uranus_details),
                    imageResourceId = R.drawable.uranus,
                    cold = true,
                    gravity = false,
                    rocky = true,
                    rings = true,
                    moon = true,
                    details = Resources.getSystem().getString(R.string.uranus_details)
                ),
            Planet(
                    stringResourceId = Resources.getSystem().getString(R.string.neptune),
                    imageResourceId = R.drawable.neptune,
                    cold = true,
                    gravity = true,
                    rocky = true,
                    rings = true,
                    moon = true,
                    details = Resources.getSystem().getString(R.string.neptune_details)
                )
    )
}}

