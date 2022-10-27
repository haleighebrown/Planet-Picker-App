package com.example.planetpicker.model

data class Planet(val stringResourceId: String,
                  val imageResourceId: Int,
                  val cold: Boolean,
                  val gravity: Boolean,
                  val rocky: Boolean,
                  val rings: Boolean,
                  val moon: Boolean,
                  val details: String){

}
