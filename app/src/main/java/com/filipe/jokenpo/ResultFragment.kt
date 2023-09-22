package com.filipe.jokenpo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.filipe.jokenpo.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    lateinit var engine: JokenpoEngine
    lateinit var bind :FragmentResultBinding
    lateinit var resultTexto: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        engine = JokenpoEngine(resources.getStringArray(R.array.stringSpiner))
        bind = FragmentResultBinding.inflate(inflater, container, false)

        resultTexto = bind.resultText
        val currentPlay = arguments?.getString("currentPlay")
        currentPlay?.let {
            updateResultText(currentPlay)
        }
        setHasOptionsMenu(true)

        return bind.root
    }

    private fun updateResultText(currentPlay:String){
        val resultGame = engine.calculateResult(currentPlay)

        resultTexto.text = when(resultGame){
                Result.WIN -> "Voçê Ganhou"
                Result.LOSS->"Voçê Perdeu"
            else ->"Voçê Empatou"
        }

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
