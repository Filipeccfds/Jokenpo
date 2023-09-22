package com.filipe.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.filipe.jokenpo.databinding.ActivityMainBinding

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var navBottomNavigationView: BottomNavigationView
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    var currentPlay:String = "Pedra"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        navigationView = binding.navView
        drawerLayout = binding.root
        navBottomNavigationView = binding.bottomNavigationView

        val navHomeFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHomeFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.playerFragment,R.id.resultFragment),drawerLayout)

        navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.homeFragment  -> navBottomNavigationView.visibility = View.GONE
                else -> navBottomNavigationView.visibility = View.VISIBLE
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment ->{
                    val args = Bundle()
                    args.putString("currentPlay",currentPlay)
                    navController.navigate(it.itemId, args)
                }else -> navController.navigate(it.itemId)
            }
            true
        }
        navBottomNavigationView.setupWithNavController(navController)
        navBottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment ->{
                    val args = Bundle()
                    args.putString("currentPlay",currentPlay)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp(appBarConfiguration) || super.onNavigateUp()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val availablePlays = resources.getStringArray(R.array.stringSpiner)
        currentPlay = availablePlays[position]

        Toast.makeText(this, " Jogador selecionado : ${currentPlay}", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
    
}