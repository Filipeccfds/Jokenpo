package com.filipe.jokenpo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.filipe.jokenpo.databinding.FragmentPlayerBinding
import com.google.android.material.navigation.NavigationBarView

class PlayerFragment : Fragment() {

    private lateinit var selectPlay: Spinner
    private lateinit var onItemSelectedListener: OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onItemSelectedListener = context as OnItemSelectedListener

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentPlayerBinding.inflate(inflater, container, false)
        selectPlay = binding.spinner
        setHasOptionsMenu(true)
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter(){
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.stringSpiner,
            android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        selectPlay.adapter = adapter
        selectPlay.onItemSelectedListener = onItemSelectedListener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_settings, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.homeFragment ->{
                findNavController().navigate(R.id.homeFragment)
                true
            }
            else -> false
        }
    }

}
