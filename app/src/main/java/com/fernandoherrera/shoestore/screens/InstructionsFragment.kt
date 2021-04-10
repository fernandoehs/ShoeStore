package com.fernandoherrera.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fernandoherrera.shoestore.R
import com.fernandoherrera.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using DataBindingUtil
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions,
            container,
            false)
        binding.startButton.setOnClickListener {
            findNavController().navigate(
            InstructionsFragmentDirections.actionInstructionsToShoeListFragment()
        ) }
        return binding.root
    }

}