package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)
        val viewModel: ShoeViewModel by activityViewModels()
        viewModel.shoeList.observe(viewLifecycleOwner,
            Observer { if (it.isNotEmpty()) addShoe(it.last(), binding.linearLayoutShoes) })
        binding.fabAddNewShoe.setOnClickListener(Navigation.createNavigateOnClickListener(
            ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()))
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun addShoe(shoe: Shoe, shoeListView: ViewGroup) {
        val binding: ItemShoeBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.item_shoe, shoeListView, true)
        binding.textViewShoeName.text = shoe.name
        binding.textViewShoeCompany.text = getString(R.string.shoe_company_format, shoe.company)
        binding.textViewShoeSize.text = getString(R.string.shoe_size_format, shoe.size)
        binding.textViewShoeDescription.text = getString(R.string.shoe_description_format, shoe.description)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                requireView().findNavController().navigate(
                    ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
