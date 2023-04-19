package com.prvt.tickets.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.prvt.tickets.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * ViewModel que sirve como puente para la informacion compartida entre los diferentes fragments que
 * muestran los tickets ordenados segun sus estados.
 *
 */

@HiltViewModel
class TicketListViewModel @Inject constructor() : ViewModel() {

    //Variable que contiene todos los tickets guardados
    private val _allTickets =MutableStateFlow(listOf<Ticket>())
    val allTickets = _allTickets.asStateFlow()

    //Variable que contiene los tickets guardados con estado "Nuevo"
    private val _newTickets =MutableStateFlow(listOf<Ticket>())
    val newTickets = _newTickets.asStateFlow()

    //Variable que contiene los tickets guardados con estado "En progreso"
    private val _processingTickets =MutableStateFlow(listOf<Ticket>())
    val processingTickets = _processingTickets.asStateFlow()

    //Variable que contiene los tickets guardados con estado "Tratado"
    private val _closedTickets =MutableStateFlow(listOf<Ticket>())
    val closedTickets = _closedTickets.asStateFlow()


    /**
     * Carga todas las variables que contiene los tickets
     * @param list es la Lista de los tickets, la cual sera almacenada y ordenada
     */
    private fun setAllTickets(list: List<Ticket>){
        _allTickets.value = list
        _newTickets.value = _allTickets.value.filter { it.state == TicketState.Nuevo }
        _processingTickets.value = _allTickets.value.filter { it.state == TicketState.EnProceso }
        _closedTickets.value = _allTickets.value.filter { it.state == TicketState.Atendido }
    }

    /**
     * Funcion de test que llena con algunos tickets las listas
     */
    fun fillAllTicket(){
        val listaDeTickets = listOf(
            Ticket(
                "000",
                "Error de interfaz",
                LocalDateTime.now(),
                "Pablo",
                ResponsibleTeam.Soporte,
                IncidenceType.Feature,
                SeveralLevel.Medium,
                "1.2.3",
                "Error al mostrar imagenes en la vista principal",
                TicketState.Nuevo
            ),
            Ticket(
                "001",
                "Error de comunicacion",
                LocalDateTime.now(),
                "Rafael",
                ResponsibleTeam.AtencionClientes,
                IncidenceType.Bug,
                SeveralLevel.Low,
                "1.2.3",
                "A veces da error al cargar datos",
                TicketState.EnProceso
            ),
            Ticket(
                "002",
                "Error de grave",
                LocalDateTime.now(),
                "Javier",
                ResponsibleTeam.Desarrollo,
                IncidenceType.Bug,
                SeveralLevel.High,
                "1.2.4",
                "Se cierra la aplicacion al entrar a la pestana 'HOME'",
                TicketState.Nuevo
            ),
            Ticket(
                "003",
                "Se conjela",
                LocalDateTime.now(),
                "Anahi",
                ResponsibleTeam.Desarrollo,
                IncidenceType.Feature,
                SeveralLevel.Medium,
                "1.2.4",
                "Se conjela la aplicacion cuando cambio de imagen",
                TicketState.Atendido
            ),
            Ticket(
                "004",
                "No puedo cambiar de contrasena",
                LocalDateTime.now(),
                "Rocio",
                ResponsibleTeam.AtencionClientes,
                IncidenceType.Feature,
                SeveralLevel.Medium,
                "1.2.4",
                "No aparece la opcion 'reiniciar contrasena' en los datos de mi cuenta",
                TicketState.Atendido
            ),
        )

        setAllTickets(listaDeTickets)
        println( "VIEWMODEL ${ newTickets.value.size }")
        println( "VIEWMODEL_all ${_allTickets.value.size }")
        println( "VIEWMODELall ${allTickets.value.size }")
    }
}