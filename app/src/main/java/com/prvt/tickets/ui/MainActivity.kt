package com.prvt.tickets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.prvt.tickets.R
import com.prvt.tickets.domain.TabLayoutAdapter
import com.prvt.tickets.databinding.ActivityMainBinding
import com.prvt.tickets.ui.viewmodels.TicketListViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity principal en la cual se configura la navegacion de la aplicacion.
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val ticketListViewModel: TicketListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //Configuracion inicial del Navigation Component
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.nav_tabMenuFragment)
    }
}