package com.example.flixster

import com.google.gson.annotations.SerializedName

class KnownForItem {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("media_type")
    var mediaType: String? = null

    @JvmField
    @SerializedName("poster_path")
    var posterPath: String? = null

    @JvmField
    @SerializedName("release_date")
    var releaseDate: String? = null

    @JvmField
    @SerializedName("overview")
    var overview: String? = null
}