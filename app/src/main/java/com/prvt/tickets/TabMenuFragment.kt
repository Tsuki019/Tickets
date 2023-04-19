package com.prvt.tickets

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.prvt.tickets.databinding.FragmentTabMenuBinding
import com.prvt.tickets.domain.TabLayoutAdapter
import com.prvt.tickets.ui.MainActivity
import com.prvt.tickets.ui.viewmodels.TicketListViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Fragment inicial, contiene la configuracion inicial del TabLayout
 */

@AndroidEntryPoint
class TabMenuFragment : Fragment() {

    private var _binding: FragmentTabMenuBinding? = null
    private val binding get() = _binding!!

    private val ticketListViewModel: TicketListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTabMenuBinding.inflate(inflater, container, false)

        ticketListViewModel.fillAllTicket()

        //Configuracion inicial del TabLayout
        val tabList = listOf(
            getString(R.string.new_tickets),
            getString(R.string.processing_tickets),
            getString(R.string.closed_tickets)
        )
        val tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            when(position){
                0 -> tab.text = tabList[0]
                1 -> tab.text = tabList[1]
                2 -> tab.text = tabList[2]
            }
        }
        binding.viewPager.adapter = TabLayoutAdapter(activity as MainActivity, tabList)
        tabLayoutMediator.attach()

        //Configuracion del FloatingActionButton que navega hacia la vista de crear ticket
        binding.floatingButton.setOnClickListener{
            findNavController().navigate(R.id.nav_makeTicketFragment)
        }

        return binding.root
    }


}