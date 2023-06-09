package com.example.spinnertutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.spinnertutorial.databinding.ActivityMainBinding
import com.example.spinnertutorial.fragments.InstrumentsFrag
import com.example.spinnertutorial.fragments.LayersFrag
import com.example.spinnertutorial.fragments.MaterialsFrag
import com.example.spinnertutorial.fragments.OperationsFrag
import com.example.spinnertutorial.fragments.SizesFrag
/*
fun setupButtons (binding: ActivityMainBinding) {
    binding.btnInstruments.setOnClickListener {
        replaceFragment(InstrumentsFrag())
    }

    binding.btnOperations.setOnClickListener {
        replaceFragment(OperationsFrag())
    }
    binding.btnMaterials.setOnClickListener {
        replaceFragment(MaterialsFrag())
    }
    binding.btnLayers.setOnClickListener {
        replaceFragment(LayersFrag())
    }
    binding.btnSizes.setOnClickListener {
        replaceFragment(SizesFrag())
    }



}


fun replaceFragment(fragment: Fragment) {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.fragment_container, fragment)
    fragmentTransaction.commit()
}

 */