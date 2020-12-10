package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)
        binding.buttonLogin.setOnClickListener(Navigation.createNavigateOnClickListener(
            LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        binding.buttonNewAccount.setOnClickListener(Navigation.createNavigateOnClickListener(
            LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        return binding.root
    }

}
