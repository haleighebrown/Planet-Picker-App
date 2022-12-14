package com.example.planetpicker.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.planetpicker.databinding.ListItemBinding
import com.example.planetpicker.data.Planet
import coil.load


class ItemAdapter(private val onItemClicked: (Planet) -> Unit) :
    ListAdapter<Planet, ItemAdapter.PlanetViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class PlanetViewHolder(private var binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: Planet, context:Context) {
            binding.title.text = planet.stringResourceId
            with(binding) { planetImage.load(planet.imageResourceId) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetViewHolder {
        context = parent.context
        return PlanetViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Planet>() {
            override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return (oldItem.stringResourceId == newItem.stringResourceId)
            }

            override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                return oldItem == newItem
            }
        }
    }


}
