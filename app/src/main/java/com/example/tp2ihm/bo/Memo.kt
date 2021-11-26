package com.example.tp2ihm.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Memo (val title: String, val content: String, val priority: Int) : Parcelable
