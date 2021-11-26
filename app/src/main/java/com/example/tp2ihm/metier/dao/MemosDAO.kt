package com.example.tp2ihm.metier.dao

import androidx.room.*
import com.example.tp2ihm.metier.dto.MemoDTO

@Dao
abstract class MemosDAO
{
    @Query("SELECT * FROM memos ORDER BY title ASC")
    abstract fun getListeMemos(): MutableList<MemoDTO>
    @Query("SELECT COUNT(*) FROM memos WHERE title = :title")
    abstract fun countMemosParTitle(title: String): Long
    @Insert
    abstract fun insert(vararg memos: MemoDTO)
    @Update
    abstract fun update(vararg memos: MemoDTO)
    @Delete
    abstract fun delete(vararg memos: MemoDTO)
}