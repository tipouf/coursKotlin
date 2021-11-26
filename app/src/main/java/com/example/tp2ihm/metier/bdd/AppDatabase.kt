package com.example.tp2ihm.metier.bdd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp2ihm.metier.dao.MemosDAO
import com.example.tp2ihm.metier.dto.MemoDTO

@Database(entities = [MemoDTO::class], version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun memosDAO(): MemosDAO
}