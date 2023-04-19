package com.prvt.tickets.domain

import androidx.recyclerview.widget.RecyclerView
import com.prvt.tickets.databinding.ResumeTicketCardBinding
import com.prvt.tickets.domain.model.Ticket

/**
 * Clase tipo Holder en donde se realiza el llenado de las tarjetas que se mostraran en los
 * recyclerViews de los fragments NewTicketsFragment, ProcessingTicketsFragment y
 * ClosedTicketsFragment
 */
class ListTicketsHolder(
    private val ticketBinding: ResumeTicketCardBinding,
): RecyclerView.ViewHolder(ticketBinding.root){

    fun bindTicket(ticket: Ticket){
        ticketBinding.apply {
            id.text = ticket.id
            titleTextView.text = ticket.title
            incident.text = ticket.incidence.getStringIncidenceType(ticket.incidence)
            severity.text = ticket.several.getStringSeveralLevel(ticket.several)
        }
    }
}