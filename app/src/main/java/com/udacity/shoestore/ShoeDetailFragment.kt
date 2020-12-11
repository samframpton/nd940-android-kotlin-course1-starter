package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)
        val viewModel: ShoeViewModel by activityViewModels()
        binding.viewModel = viewModel
        viewModel.resetShoe()
        binding.buttonSaveShoe.setOnClickListener {
            viewModel.addShoe()
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        binding.buttonCancelShoe.setOnClickListener(Navigation.createNavigateOnClickListener(
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()))
        return binding.root
    }

}
