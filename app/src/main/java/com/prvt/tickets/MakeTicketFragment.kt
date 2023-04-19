package com.prvt.tickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.prvt.tickets.databinding.FragmentMakeTicketBinding
import com.prvt.tickets.domain.model.*
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime


/**
 * Fragmento donde se crea un nuevo ticket.
 */

@AndroidEntryPoint
class MakeTicketFragment : Fragment() {

    private var _binding: FragmentMakeTicketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMakeTicketBinding.inflate(inflater, container, false)

        binding.cancelButton.setOnClickListener{
            findNavController().popBackStack()
        }

//        binding.submitTicketButton.setOnClickListener{
//            val stateSave = saveTicket()
//            when(stateSave){
//                1 -> Toast.makeText(context, "Ticket guardado con exito!", Toast.LENGTH_SHORT).show()
//                2 -> Toast.makeText(context, "Error al guardar el ticket.", Toast.LENGTH_SHORT).show()
//                0 -> Toast.makeText(context, "Llene los campos obligatorios.", Toast.LENGTH_SHORT).show()
//            }
//        }
        return binding.root
    }


    /**
     * Verifica si los campos obligatorios fueron llenados y guarda el ticket en la base de datos
     * @return < 0 > si no se llenaron todos lo campos obligatorios
     * @return < 1 > si se guardo el ticket de manera exitosa
     * @return < 2 > si ocurrio algun error al tratar de guardar el ticket en la base de datos
     * */
    private fun saveTicket(): Int{

        binding.apply {
            if(titleEditText.text.toString() == "" ||
                    responsibleEditText.text.toString() == "" ||
                    descriptionEditText.text.toString() == "")
                return 0

            val currentTicket = Ticket(
                "0",
                titleEditText.text.toString(),
                LocalDateTime.now(),
                responsibleEditText.text.toString(),
                getResponsibleTeam(responsibleEditText.text.toString())!!,
                getIncidenceType(incidentTextView.text.toString())!!,
                getSeveralLevel(severalTextView.text.toString())!!,
                versionEditText.text.toString(),
                descriptionEditText.text.toString(),
                TicketState.Nuevo
            )
        }

        //TODO guardar ticket en BD
        return 1
    }


    /**
     * Regresa el tipo de Equipo Responsable segun el dato de entrada
     * @param team es el equipo que elige el usuario cuando crea el ticket
     */
    private fun getResponsibleTeam(team: String): ResponsibleTeam?{
        when (team){
            "Soporte" -> return ResponsibleTeam.Soporte
            "Desarrollo" -> return ResponsibleTeam.Desarrollo
            "AtencionClientes" -> return ResponsibleTeam.AtencionClientes
        }
        return null
    }

    /**
     * Regresa el tipo de Incidente segun el dato de entrada
     * @param incidence es el tipo de incidente que elige el usuario cuando crea el ticket
     */
    private fun getIncidenceType(incidence: String): IncidenceType?{
        when (incidence){
            "Bug" -> return IncidenceType.Bug
            "Feature" -> return IncidenceType.Feature
        }
        return null
    }

    /**
     * Regresa el nivel de gravedad segun el dato de entrada
     * @param level es el nivel de gravedad que elige el usuario cuando crea el ticket
     */
    private fun getSeveralLevel(level: String): SeveralLevel?{
        when (level){
            "High" -> return SeveralLevel.High
            "Medium" -> return SeveralLevel.Medium
            "Low" -> return SeveralLevel.Low
        }
        return null
    }
}
