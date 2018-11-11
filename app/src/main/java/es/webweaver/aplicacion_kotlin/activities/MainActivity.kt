package es.webweaver.aplicacion_kotlin.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import es.webweaver.aplicacion_kotlin.R
import es.webweaver.aplicacion_kotlin.fragments.ArrivalsFragment
import es.webweaver.aplicacion_kotlin.fragments.DeparturesFragment
import es.webweaver.aplicacion_kotlin.fragments.HomeFragment
import es.webweaver.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarToLoad(toolbar as Toolbar)

        setNavDrawer()
        fragmentTransaction(HomeFragment())
        navView.menu.getItem(0).isChecked = true
    }

    private fun setNavDrawer(){
        val toogle = ActionBarDrawerToggle(this, drawerLayout,_toobar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        toogle.isDrawerIndicatorEnabled =true
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }
    private fun fragmentTransaction(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> fragmentTransaction(HomeFragment())
            R.id.nav_departures -> fragmentTransaction(DeparturesFragment())
            R.id.nav_arrivals -> fragmentTransaction(ArrivalsFragment())
        }
        return true
    }
}
