package com.prvt.tickets.domain.model

import java.time.LocalDateTime

/**
 * Data class de Ticket, contiene ademas las sealed class usadas para su inicializacion.
 */

data class Ticket(
    var id: String,
    var title: String,
    var date:LocalDateTime,
    var responsible: String,
    var team: ResponsibleTeam,
    var incidence: IncidenceType,
    var several: SeveralLevel,
    var version: String,
    var description: String,
    var state: TicketState
)

sealed class ResponsibleTeam{
    object Soporte:ResponsibleTeam()
    object Desarrollo: ResponsibleTeam()
    object AtencionClientes: ResponsibleTeam()

    /**
     * Regresa el equipo resposable en formato String
     */
    fun getStringResponsibleTeam(team: ResponsibleTeam): String{
        return when(team){
            AtencionClientes -> "Soporte"
            Desarrollo -> "Desarrollo"
            Soporte -> "AtencionClientes"
        }
    }
}

sealed class IncidenceType{
    object Bug: IncidenceType()
    object Feature: IncidenceType()

    /**
     * Regresa el tipo de incidente en formato String
     */
    fun getStringIncidenceType(incidence: IncidenceType): String{
        return when(incidence){
            Bug -> "Bug"
            Feature -> "Feature"
        }
    }
}

sealed class SeveralLevel{
    object High: SeveralLevel()
    object Medium: SeveralLevel()
    object Low: SeveralLevel()

    /**
     * Regresa el nivel de gravedad en formato String
     */
    fun getStringSeveralLevel(level: SeveralLevel): String{
        return when(level){
            High -> "High"
            Low -> "Low"
            Medium -> "Medium"
        }
    }
}

sealed class TicketState{
    object Nuevo: TicketState()
    object EnProceso: TicketState()
    object Atendido: TicketState()

    /**
     * Regresa el estado del ticket en formato String
     */
    fun getStringState(state: TicketState): String{
        return when(state){
            Atendido -> "Atendido"
            EnProceso -> "En Proceso"
            Nuevo -> "Nuevo"
        }
    }
}