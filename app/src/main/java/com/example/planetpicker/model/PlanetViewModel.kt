package com.example.planetpicker.model
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.planetpicker.data.PlanetsData
import com.example.planetpicker.model.Planet

class PlanetViewModel: ViewModel(){
    private var _planetsData: ArrayList<Planet> = ArrayList()
    val planetsData: ArrayList<Planet>
        get() = _planetsData

    private val _cold = MutableLiveData<String>()
    val cold: LiveData<String> = _cold

    private val _gravity = MutableLiveData<String>()
    val gravity: LiveData<String> = _gravity

    private val _rocky = MutableLiveData<String>()
    val rocky: LiveData<String> = _rocky

    private val _rings = MutableLiveData<String>()
    val rings: LiveData<String> = _rings

    private val _moon = MutableLiveData<String>()
    val moon: LiveData<String> = _moon

    private var _currentPlanet: MutableLiveData<Planet> = MutableLiveData<Planet>()
    val currentPlanet: LiveData<Planet>
        get() = _currentPlanet
    private var _planetData: ArrayList<Planet> = ArrayList()
    val planetData: ArrayList<Planet>
        get() = _planetData

    init {
        _planetsData = PlanetsData.getPlanetsData()
        _currentPlanet.value = _planetsData[0]
        reset()
    }
    fun updateCurrentPlanet(planet: Planet) {
        _currentPlanet.value = planet
    }
    fun setCold() {
        if (_cold.value =="Yes") {
            _cold.value = "No"
        }else {_cold.value = "Yes"}
    }
    fun setGravity() {
        if (_gravity.value == "Yes") {
        _gravity.value = "No"
    }else {_gravity.value = "Yes"}
    }
    fun setRocky() {
        if (_rocky.value == "Yes") {
            _rocky.value = "No"
        }else {_rocky.value = "Yes"}
    }
    fun setRings() {
        if (_rings.value == "Yes") {
            _rings.value = "No"
        }else {_rings.value = "Yes"}
    }
    fun setMoon() {
        if (_moon.value == "Yes") {
            _moon.value = "No"
        }else {_moon.value = "Yes"}
    }

    fun reset() {
        _currentPlanet.value = _planetsData[0]
        _cold.value = "No"
        _gravity.value = "No"
        _rocky.value = "No"
        _rings.value = "No"
        _moon.value = "No"
    }
}


/*

    for (plan in planets) {
        if (plan.cold == cold && plan.gravity == gravity && plan.rocky == rocky && plan.rings == rings && plan.moon == moons) {
            Planet += plan
        }
*/