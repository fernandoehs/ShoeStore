package com.fernandoherrera.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fernandoherrera.shoestore.MainActivityViewModel
import com.fernandoherrera.shoestore.R
import com.fernandoherrera.shoestore.databinding.FragmentDetailBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.fernandoherrera.shoestore.models.Shoe


class DetailFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using DataBindingUtil
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        // Initialize view model and "empty" shoe object
        binding.viewModel = viewModel
        binding.shoe = Shoe("",0.0,"","")

        // Observer for event when shoe is added. It will navigate back to the shoe list
        // where the new shoe will be displayed at the bottom of the list
        viewModel.eventShoeAdded.observe(viewLifecycleOwner, Observer { isAdded ->
            if (isAdded) {
                findNavController().popBackStack()
                viewModel.shoeAddedComplete()
            }
        })

        // Add listener for cancel button which will simply navigate bac to the shoe list screen
        binding.cancelButton.setOnClickListener { findNavController().popBackStack() }
        return binding.root
    }

}