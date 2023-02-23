package com.example.flixster

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.gson.Gson


const val ACTOR_EXTRA = "ACTOR_EXTRA"

class ActorAdapter (
    private val context: Context,
    private val actors: List<Actor>
    ) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_actor, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = actors[position]
        holder.bind(actor)
    }

    override fun getItemCount() = actors.size

    inner class ActorViewHolder(val mView: View) : RecyclerView.ViewHolder(mView),
        View.OnClickListener {

        private var mItem: Actor? = null
        private val mActorName: TextView = mView.findViewById<View>(R.id.actor_name) as TextView
        private val mActorPortrait: ImageView = mView.findViewById<View>(R.id.actor_portrait) as ImageView

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(actor: Actor) {
            mItem = actor
            mActorName.text = actor.name.toString()

            Glide.with(mView)
                .load("https://image.tmdb.org/t/p/w500/${actor.profilePath}")
                .centerInside()
                .placeholder(R.drawable.my_project__1_)
                .error(R.drawable.my_project__1_)
                .transform(RoundedCorners(20))
                .into(mActorPortrait)
        }

        override fun onClick(v: View?) {
            // Get selected article
            val actor = actors[adapterPosition]
            val gson = Gson()
            val myJson = gson.toJson(actor)

            // Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ACTOR_EXTRA, myJson)
            context.startActivity(intent)
        }
    }
}