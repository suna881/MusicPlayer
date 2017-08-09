package com.sunasteffen.musicplayer

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sunasteffen.musicplayer.dummy.Content

class SimpleItemRecyclerViewAdapter(private val mValues: List<Content.SongItem>, private val mTwoPane: Boolean, private val listener: Listener) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.song_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mIdView.text = mValues[position].id
        holder.mContentView.text = mValues[position].content

        holder.mView.setOnClickListener { v ->
            if (mTwoPane) {
                listener.onItemClicked(holder.mItem!!.id)
            } else {
                val context = v.context
                val intent = Intent(context, SongDetailActivity::class.java)
                intent.putExtra(SongDetailFragment.ARG_ITEM_ID, holder.mItem!!.id)

                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        val mContentView: TextView
        var mItem: Content.SongItem? = null

        init {
            mIdView = mView.findViewById<View>(R.id.id) as TextView
            mContentView = mView.findViewById<View>(R.id.content) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

    interface Listener {
        fun onItemClicked(id: String)
    }
}