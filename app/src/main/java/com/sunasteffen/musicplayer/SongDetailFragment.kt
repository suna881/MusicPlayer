package com.sunasteffen.musicplayer

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sunasteffen.musicplayer.dummy.Content

class SongDetailFragment : Fragment() {
    private var mItem: Content.SongItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(ARG_ITEM_ID)) {
            // TODO: Use a content provider to load content
            mItem = Content.ITEM_MAP[arguments.getString(ARG_ITEM_ID)]

            val activity = this.activity
            val appBarLayout = activity.findViewById<View>(R.id.toolbar_layout) as CollapsingToolbarLayout
            if (appBarLayout != null) {
                appBarLayout.title = mItem!!.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.song_detail, container, false)

        if (mItem != null) {
            (rootView.findViewById<View>(R.id.song_detail) as TextView).text = mItem!!.details
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        val ARG_ITEM_ID = "item_id"
    }
}
