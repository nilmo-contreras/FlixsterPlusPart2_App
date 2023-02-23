package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class KnownForAdapter (
    private val knownForList: List<KnownForItem>
    ) : RecyclerView.Adapter<KnownForAdapter.KnownForViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KnownForViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_known_for, parent, false)
        return KnownForViewHolder(view)
    }

    override fun getItemCount() = knownForList.size

    override fun onBindViewHolder(holder: KnownForViewHolder, position: Int) {
        val knownFor = knownForList[position]
        holder.bind(knownFor)
    }

    inner class KnownForViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        private var mItem: KnownForItem? = null
        private val mKnownForPoster: ImageView = mView.findViewById<View>(R.id.movie_poster) as ImageView
        private val mKnownForTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
        private val mKnownForMediaType: TextView = mView.findViewById<View>(R.id.media_type) as TextView
        private val mKnownForReleaseDate: TextView = mView.findViewById<View>(R.id.release_date) as TextView
        private val mKnownForOverview: TextView = mView.findViewById<View>(R.id.overview) as TextView

        fun bind(other: KnownForItem) {
            mItem = other
            mKnownForTitle.text = mItem!!.title
            mKnownForMediaType.text = mItem!!.mediaType
            mKnownForReleaseDate.text = mItem!!.releaseDate
            mKnownForOverview.text = mItem!!.overview

            Glide.with(mView)
                .load("https://image.tmdb.org/t/p/w500/${mItem!!.posterPath}")
                .centerInside()
                .placeholder(R.drawable.my_project__1_)
                .error(R.drawable.my_project__1_)
                .transform(RoundedCorners(20))
                .into(mKnownForPoster)
        }
    }
}