package com.example.planetpicker.model

import androidx.lifecycle.*
import com.example.planetpicker.data.Planet
import com.example.planetpicker.data.PlanetDao
import com.example.planetpicker.data.PlanetsData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections.list
import androidx.lifecycle.LiveData as LiveData

class PlanetViewModel(private val planetDao: PlanetDao): ViewModel() {

    val allPlanets: LiveData<List<Planet>> = planetDao.getPlanets().asLiveData()

    fun addFavPlanet(planet: Planet) {
        viewModelScope.launch {
            planetDao.update(planet.copy(fav = true))
        }
    }


    fun deleteFavPlanet(planet: Planet) {
        viewModelScope.launch {
            planetDao.update(planet.copy(fav = true))
        }
    }

    private var _planetsData: ArrayList<Planet> = ArrayList()
    private var _listToView: ArrayList<Planet> = ArrayList()

    val planetsData: ArrayList<Planet>
        get() = _planetsData

    val listToView: ArrayList<Planet>
        get() = _listToView


    private val _cold = MutableLiveData<Boolean>()
    val cold: LiveData<Boolean> = _cold
    private val _gravity = MutableLiveData<Boolean>()
    val gravity: LiveData<Boolean> = _gravity
    private val _rocky = MutableLiveData<Boolean>()
    val rocky: LiveData<Boolean> = _rocky
    private val _rings = MutableLiveData<Boolean>()
    val rings: LiveData<Boolean> = _rings
    private val _moon = MutableLiveData<Boolean>()
    val moon: LiveData<Boolean> = _moon
    private var _currentPlanet: MutableLiveData<Planet> = MutableLiveData<Planet>()
    val currentPlanet: LiveData<Planet>
        get() = _currentPlanet

    init {
        _planetsData = PlanetsData.getPlanetsData()
        for (planet in _planetsData) {
            CoroutineScope(Dispatchers.IO).launch {
                planetDao.insert(planet)
            }
        }

        _currentPlanet.value = _planetsData[0]
        reset()
    }

    fun updateCurrentPlanet(planet: Planet) {
        _currentPlanet.value = planet
    }

    fun setCold() {
        if (_cold.value == true) {
            _cold.value = false
        } else {
            _cold.value = true
        }
    }

    fun setGravity() {
        if (_gravity.value == true) {
            _gravity.value = false
        } else {
            _gravity.value = true
        }
    }

    fun setRocky() {
        if (_rocky.value == true) {
            _rocky.value = false
        } else {
            _rocky.value = true
        }
    }

    fun setRings() {
        if (_rings.value == true) {
            _rings.value = false
        } else {
            _rings.value = true
        }
    }

    fun setMoon() {
        if (_moon.value == true) {
            _moon.value = false
        } else {
            _moon.value = true
        }
    }

    fun reset() {
        _currentPlanet.value = _planetsData[0]
        _cold.value = false
        _gravity.value = false
        _rocky.value = false
        _rings.value = false
        _moon.value = false
    }

    fun toViewFav(favListToView: ArrayList<Planet>) {
        listToView.clear()
        for (planet in favListToView) {
            if(planet.fav) {
                listToView += planet
            }
        }
    }

    fun toViewSearch(searchListToView: ArrayList<Planet>) {
        listToView.clear()
        for (planet in searchListToView) {
            if(_cold.value == planet.cold &&
                _gravity.value == planet.gravity &&
                _rocky.value == planet.rocky &&
                _moon.value == planet.moon &&
                _rings.value == planet.rings
            ) {
                listToView += planet
            }
        }
    }

    class PlanetViewModelFactory(private val planetDao: PlanetDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PlanetViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PlanetViewModel(planetDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}







