package es.webweaver.aplicacion_kotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import es.webweaver.aplicacion_kotlin.R
import es.webweaver.aplicacion_kotlin.inflate
import es.webweaver.aplicacion_kotlin.listeners.RecyclerFlightListener
import es.webweaver.aplicacion_kotlin.loadByResource
import es.webweaver.aplicacion_kotlin.models.Flight
import kotlinx.android.synthetic.main.recycle_flight.view.*

class FlightAdapter(private val  flight: List<Flight>, private val listener: RecyclerFlightListener)
    : RecyclerView.Adapter<FlightAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycle_flight))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(flight[position], listener)

    override fun getItemCount() = flight.size


    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(flight: Flight, listener: RecyclerFlightListener)= with(itemView){
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)
            // Click Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}