package com.example.aplikasigithubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name : String,
    var username : String,
    var location : String,
    var company : String,
    var repository : String,
    var following : String,
    var followers :String,
    var avatar : Int
) : Parcelable
