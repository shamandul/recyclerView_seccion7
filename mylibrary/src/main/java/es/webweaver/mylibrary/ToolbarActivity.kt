package es.webweaver.mylibrary

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import es.webweaver.mylibrary.interfaces.IToolbar


open class ToolbarActivity : AppCompatActivity(), IToolbar {

    protected var _toobar: Toolbar? =null

    override fun toolbarToLoad(toolbar: Toolbar) {
        _toobar=toolbar
        _toobar?.let { setSupportActionBar(_toobar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }

}