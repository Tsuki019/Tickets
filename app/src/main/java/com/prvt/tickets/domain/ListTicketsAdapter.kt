package com.prvt.tickets.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prvt.tickets.databinding.ResumeTicketCardBinding
import com.prvt.tickets.domain.model.Ticket


/**
 * Adapter que se encarga del llenado y de inflar las tarjetas que aparecen los fragments
 * NewTicketsFragment, ProcessingTicketsFragment y ClosedTicketsFragment
 */
class ListTicketsAdapter(
    private val ticketList: List<Ticket>
): RecyclerView.Adapter<ListTicketsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListTicketsHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ResumeTicketCardBinding.inflate(from, parent, false)
        return ListTicketsHolder(binding)
    }

    override fun getItemCount(): Int {
        return ticketList.size
    }

    override fun onBindViewHolder(holder: ListTicketsHolder, position: Int) {
        holder.bindTicket(ticketList[position])
    }

}