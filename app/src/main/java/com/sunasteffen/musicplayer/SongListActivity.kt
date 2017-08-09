package com.sunasteffen.musicplayer


import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.sunasteffen.musicplayer.dummy.Content

class SongListActivity : AppCompatActivity(), SimpleItemRecyclerViewAdapter.Listener {

    private var mTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val recyclerView = findViewById<View>(R.id.song_list)!!
        setupRecyclerView(recyclerView as RecyclerView)

        if (findViewById<View>(R.id.song_detail_container) != null) {
            mTwoPane = true
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(Content.ITEMS, mTwoPane, this)
    }

    override fun onItemClicked(id: String) {
        val arguments = Bundle()
        arguments.putString(SongDetailFragment.ARG_ITEM_ID, id)
        val fragment = SongDetailFragment()
        fragment.arguments = arguments
        supportFragmentManager.beginTransaction()
                .replace(R.id.song_detail_container, fragment)
                .commit()
    }
}
