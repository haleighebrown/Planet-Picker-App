package com.example.planetpicker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Planet(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int, @BooleanRes val cold: Boolean,
                  @BooleanRes val gravity: Boolean, @BooleanRes val rocky: Boolean, @BooleanRes val rings: Boolean, @BooleanRes val moon: Boolean,) {

}

annotation class BooleanRes
