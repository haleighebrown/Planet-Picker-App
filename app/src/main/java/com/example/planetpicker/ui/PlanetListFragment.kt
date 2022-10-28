package com.example.planetpicker.ui

import com.example.planetpicker.model.PlanetViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.planetpicker.R
import com.example.planetpicker.databinding.FragmentPlanetListBinding



class PlanetListFragment : Fragment() {
    class PlanetListOnBackPressedCallback(
        private val slidingPaneLayout: SlidingPaneLayout
    ): OnBackPressedCallback(slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen),
        SlidingPaneLayout.PanelSlideListener{

        init {
            slidingPaneLayout.addPanelSlideListener(this)
        }

        override fun handleOnBackPressed() {
            slidingPaneLayout.closePane()
        }

        override fun onPanelSlide(panel: View, slideOffset: Float) {
        }

        override fun onPanelOpened(panel: View) {
            isEnabled = true
        }

        override fun onPanelClosed(panel: View) {
            isEnabled = false
        }
    }

    private val sharedViewModel: PlanetViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentPlanetListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPlanetListBinding.bind(view)
        val slidingPaneLayout = binding.slidingPaneLayout
        // Initialize the adapter and set it to the RecyclerView.
        val adapter = ItemAdapter {
            sharedViewModel.updateCurrentPlanet(it)
            // Navigate to the details screen
            binding.slidingPaneLayout.openPane()
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            PlanetListOnBackPressedCallback(slidingPaneLayout)
        )
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        binding.recyclerView.adapter = adapter
        adapter.submitList(sharedViewModel.planetsData)
    }
}