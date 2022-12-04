package com.example.planetpicker.ui
import android.content.ClipData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.planetpicker.PlanetPickerApplication
import com.example.planetpicker.R
import com.example.planetpicker.databinding.FragmentPlanetDetailsBinding
import com.example.planetpicker.model.Planet
import com.example.planetpicker.model.PlanetViewModel



class PlanetDetailsFragment : Fragment() {

    private val sharedViewModel: PlanetViewModel by activityViewModels()
    {
        PlanetViewModel.PlanetViewModelFactory(
            (activity?.application as PlanetPickerApplication).database.planetDao()
        )
    }


    lateinit var planet: Planet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPlanetDetailsBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPlanetDetailsBinding.bind(view)


        sharedViewModel.currentPlanet.observe(this.viewLifecycleOwner) {
            planet = it
            binding.titleDetail.text = it.stringResourceId
            binding.TitleDetail.text = it.stringResourceId
            binding.planetsImageDetail.load(it.imageResourceId)
            binding.planetDetail.text = it.details
        }
    }
    fun goToSearchScreen() {
        findNavController().navigate(R.id.action_planetDetailsFragment_to_startFragment)
    }

    fun goToFavScreen() {
        sharedViewModel.addFavPlanet(planet)
        findNavController().navigate(R.id.action_PlanetDetailsFragment_to_planetFavListFragment)
    }

}