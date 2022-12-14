package com.example.planetpicker.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.planetpicker.PlanetPickerApplication
import com.example.planetpicker.R
import com.example.planetpicker.databinding.FragmentPlanetDetailsBinding
import com.example.planetpicker.data.Planet
import com.example.planetpicker.model.PlanetViewModel


class PlanetDetailsFragment : Fragment() {
    private val navigationArgs: PlanetDetailsFragmentArgs by navArgs()
    lateinit var planet: Planet


    private val sharedViewModel: PlanetViewModel by activityViewModels()
    {
        PlanetViewModel.PlanetViewModelFactory(
            (activity?.application as PlanetPickerApplication).database.planetDao()
        )
    }

    private var _binding: FragmentPlanetDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlanetDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            sharedViewModel = sharedViewModel
            planetDetailsFragment = this@PlanetDetailsFragment

        }

        sharedViewModel.currentPlanet.observe(this.viewLifecycleOwner) {
            planet = it
            binding.addFav.setOnClickListener {
                sharedViewModel.addFavPlanet(planet)
                findNavController().navigate(R.id.action_planetListFragment_to_startFragment)
                sharedViewModel.reset()
                Toast.makeText(requireActivity(), "Planet added to Favorites!", Toast.LENGTH_LONG).show()
            }
            binding.titleDetail.text = it.stringResourceId
            binding.TitleDetail.text = it.stringResourceId
            binding.planetsImageDetail.load(it.imageResourceId)
            binding.planetDetail.text = it.details
        }

    }


    fun goToSearchScreen() {
        sharedViewModel.reset()
        findNavController().navigate(R.id.action_planetListFragment_to_startFragment)
    }

}