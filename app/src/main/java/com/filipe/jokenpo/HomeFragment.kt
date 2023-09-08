package com.filipe.jokenpo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.filipe.jokenpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater,container, false)

        binding.btn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToNavigation()
            findNavController().navigate(action)
        }

        lifecycle.addObserver(Obsever())
        return binding.root
    }




}