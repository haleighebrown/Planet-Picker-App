package com.example.planetpicker.ui
import com.example.planetpicker.model.PlanetViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.planetpicker.PlanetPickerApplication
import com.example.planetpicker.databinding.FragmentPlanetDetailsBinding



class PlanetDetailsFragment : Fragment() {
    private val sharedViewModel: PlanetViewModel by activityViewModels()
    {
        PlanetViewModel.PlanetViewModelFactory(
            (activity?.application as PlanetPickerApplication).database.planetDao()
        )
    }

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
            binding.titleDetail.text = it.stringResourceId
            binding.TitleDetail.text = it.stringResourceId
            binding.planetsImageDetail.load(it.imageResourceId)
            binding.planetDetail.text = it.details
        }
    }

}