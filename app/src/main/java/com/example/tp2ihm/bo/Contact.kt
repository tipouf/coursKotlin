package com.example.tp2ihm.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact (val nom: String, val numero:String): Parcelable