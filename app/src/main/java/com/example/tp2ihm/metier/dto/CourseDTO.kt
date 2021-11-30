package com.example.tp2ihm.metier.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "courses")
data class CourseDTO(
    @PrimaryKey(autoGenerate = true)
    var courseId: Long = 0,
    var intitule: String? = null,
    var achete: Boolean = false,
    var categorie: String? = null,
    var prix: Float = 0F) : Parcelable