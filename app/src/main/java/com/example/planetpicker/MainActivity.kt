package com.example.planetpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.planetpicker.adapter.ItemAdapter
import com.example.planetpicker.data.Datasource
import com.example.planetpicker.databinding.ActivityMainBinding

private var submitButton: TextView? = null


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.submitButton.setOnClickListener  {
            val  cold = binding.coldSwitch.isChecked
            val gravity = binding.gravitySwitch.isChecked
            val  rocky = binding.rockySwitch.isChecked
            val  rings = binding.ringSwitch.isChecked
            val  moons = binding.moonSwitch.isChecked
            val myDataset = Datasource().loadPlanet(cold, gravity, rocky, rings, moons)
            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.adapter = ItemAdapter(this, myDataset)
            recyclerView.setHasFixedSize(true)
        }






    }



}