package es.webweaver.aplicacion_kotlin.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.webweaver.aplicacion_kotlin.R
import es.webweaver.aplicacion_kotlin.adapters.FlightAdapter
import es.webweaver.aplicacion_kotlin.listeners.RecyclerFlightListener
import es.webweaver.aplicacion_kotlin.models.Flight
import es.webweaver.aplicacion_kotlin.toast


import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    private val list: ArrayList<Flight> by lazy { getFlights()  }
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: FlightAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)
        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()

        return rootView
    }

    private fun setRecyclerView(){
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager= layoutManager

        adapter= (FlightAdapter(list, object : RecyclerFlightListener {
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let's go to ${flight.city}!")
            }

            override fun onDelete(flight: Flight, position: Int) {

                list.remove(flight)
                adapter.notifyItemRemoved(position)
                activity?.toast("${flight.city} has been removed!")
            }

        }))
        recycler.adapter = adapter
    }

    private fun getFlights(): ArrayList<Flight>{
        return object: ArrayList<Flight>(){
            init {
                add(Flight(1, "Cádiz", R.drawable.cadiz))
                add(Flight(2, "Dublín", R.drawable.dublin))
                add(Flight(3, "Genova", R.drawable.genova))
                add(Flight(4, "Grecia", R.drawable.grecia))
                add(Flight(5, "Londres", R.drawable.london))
                add(Flight(6, "Madrid", R.drawable.madrid))
                add(Flight(7, "Nueva York", R.drawable.new_york_city))
                add(Flight(8, "París", R.drawable.paris))
                add(Flight(9, "Seattle", R.drawable.seattle))
                add(Flight(10, "Estocolmo", R.drawable.stockholm))
                add(Flight(11, "Tokyo", R.drawable.tokyo))

            }
        }
    }


}
