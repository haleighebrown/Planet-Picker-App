package com.example.planetpicker.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Planet(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int) {

}