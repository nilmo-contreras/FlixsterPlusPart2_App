package com.example.flixster

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.gson.Gson

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var actorImageView: ImageView
    private lateinit var actorNameView: TextView
    private lateinit var knownForRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        val gson = Gson()
        val actor = gson.fromJson(intent.getStringExtra(ACTOR_EXTRA), Actor::class.java)

        Log.d("actor", actor.knownFor[1].overview.toString())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        actorImageView = findViewById(R.id.actor_portrait)
        actorNameView = findViewById(R.id.actor_name)

        knownForRecyclerView = findViewById(R.id.known_for)
        val knownForAdapter = KnownForAdapter(actor.knownFor)
        knownForRecyclerView.adapter = knownForAdapter
        knownForRecyclerView.layoutManager = LinearLayoutManager(this)

        actorNameView.text = actor.name

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${actor.profilePath}")
            .centerInside()
            .placeholder(R.drawable.my_project__1_)
            .error(R.drawable.my_project__1_)
            .transform(RoundedCorners(20))
            .into(actorImageView)
    }
}