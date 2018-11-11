package es.webweaver.aplicacion_kotlin

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import es.webweaver.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarToLoad(toolbar as Toolbar)
    }

    private fun setNavDrawer(){
       // val toogle = ActionBarDrawerToggle(this, drawerLayout)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return true
    }
}
