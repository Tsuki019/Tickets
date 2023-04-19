package com.prvt.tickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prvt.tickets.databinding.FragmentClosedTicketsBinding
import com.prvt.tickets.domain.ListTicketsAdapter
import com.prvt.tickets.ui.viewmodels.TicketListViewModel

/**
 * Fragmento en donde se muestran los Tickets que se encuentran Cerrados (ya fueron tratados).
 */

class ClosedTicketsFragment : Fragment() {

    private var _binding: FragmentClosedTicketsBinding? = null
    private val binding get() = _binding!!

    private val ticketListViewModel: TicketListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentClosedTicketsBinding.inflate(inflater, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListTicketsAdapter(ticketListViewModel.closedTickets.value)
        }
        return binding.root
    }
}