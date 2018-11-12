package es.webweaver.aplicacion_kotlin.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.webweaver.aplicacion_kotlin.R
import es.webweaver.aplicacion_kotlin.models.Flight

class DeparturesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_departures, container, false)
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
