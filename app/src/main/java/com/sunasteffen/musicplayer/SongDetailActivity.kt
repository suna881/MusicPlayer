package com.sunasteffen.musicplayer

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View

class SongDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)
        val toolbar = findViewById<View>(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val arguments = Bundle()
            arguments.putString(SongDetailFragment.ARG_ITEM_ID,
                    intent.getStringExtra(SongDetailFragment.ARG_ITEM_ID))
            val fragment = SongDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .add(R.id.song_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, Intent(this, SongListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
