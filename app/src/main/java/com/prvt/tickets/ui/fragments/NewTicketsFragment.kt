package com.prvt.tickets.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.prvt.tickets.R
import com.prvt.tickets.databinding.FragmentMakeTicketBinding
import com.prvt.tickets.databinding.FragmentNewTicketsBinding
import com.prvt.tickets.domain.ListTicketsAdapter
import com.prvt.tickets.ui.viewmodels.TicketListViewModel
import dagger.hilt.EntryPoint

/**
 *  Esta subclase de [Fragment] es la vista donde se muestran los tickets que tienen como estado
 *  "Nuevo"
 */

class NewTicketsFragment : Fragment() {

    private var _binding: FragmentNewTicketsBinding? = null
    private val binding get() = _binding!!

    private val ticketListViewModel: TicketListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNewTicketsBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListTicketsAdapter(ticketListViewModel.newTickets.value)
        }
        return binding.root
    }
}