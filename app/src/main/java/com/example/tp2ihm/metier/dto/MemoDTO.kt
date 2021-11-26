package com.example.tp2ihm.metier.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "memos")
data class MemoDTO(
    @PrimaryKey(autoGenerate = true)
    var memoId: Long = 0,
    var title: String? = null,
    var content: String? = null,
    var priority: Int? = null) : Parcelable

