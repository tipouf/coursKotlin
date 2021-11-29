package com.example.tp2ihm.bo

import com.google.gson.annotations.SerializedName

data class Planet (
    @SerializedName("name")
    val name:String,
    @SerializedName("rotation_period")
    val rotation_period:String,
    @SerializedName("orbital_period")
    val orbital_period:String,
    @SerializedName("diameter")
    val diameter:String,
    @SerializedName("climate")
    val climate:String)