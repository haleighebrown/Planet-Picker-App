package com.example.planetpicker.ui

import com.example.planetpicker.model.PlanetViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.planetpicker.PlanetPickerApplication
import com.example.planetpicker.R
import com.example.planetpicker.data.Planet
import com.example.planetpicker.databinding.FragmentStartBinding



//import com.example.planetpicker.model.PlanetViewModelFactory


class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private var listToView: ArrayList<Planet> = ArrayList()
    private val sharedViewModel: PlanetViewModel by activityViewModels()
    {
        PlanetViewModel.PlanetViewModelFactory(
            (activity?.application as PlanetPickerApplication).database.planetDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            startFragment = this@StartFragment
            binding.viewModel?.allPlanets?.observe(viewLifecycleOwner){
                listToView = it as ArrayList<Planet>
            }

        }

    }

    fun goToNextScreen() {
        sharedViewModel.toViewSearch(listToView)
        findNavController().navigate(R.id.action_startFragment_to_planetListFragment)
    }

    fun goToFavScreen() {
        sharedViewModel.toViewFav(listToView)
        findNavController().navigate(R.id.action_startFragment_to_planetListFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
