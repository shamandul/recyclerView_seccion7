package es.webweaver.aplicacion_kotlin.listeners

import es.webweaver.aplicacion_kotlin.models.Flight

interface RecyclerFlightListener{
    fun onClick(flight: Flight, position:Int)
    fun onDelete(flight: Flight, position:Int)

}