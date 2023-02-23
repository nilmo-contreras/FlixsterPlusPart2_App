package com.example.flixster

import com.google.gson.annotations.SerializedName

class Actor {
    @JvmField
    @SerializedName("name")
    var name: String? = null

    @SerializedName("known_for")
    lateinit var knownFor: List<KnownForItem>

    @JvmField
    @SerializedName("profile_path")
    var profilePath: String? = null
}