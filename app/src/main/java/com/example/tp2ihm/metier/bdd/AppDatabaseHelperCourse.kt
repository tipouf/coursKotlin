package com.example.tp2ihm.metier.bdd

import android.content.Context
import androidx.room.Room

class AppDatabaseHelperCourse(context: Context)
{
    // Bloc de code "static" :
    companion object
    {
        // Helper :
        private lateinit var databaseHelperCourse: AppDatabaseHelperCourse
        // Getter instance :
        fun getDatabase(context: Context): AppDatabaseCourse
        {
            if (!::databaseHelperCourse.isInitialized)
            {
                databaseHelperCourse = AppDatabaseHelperCourse(context)
            }
            return databaseHelperCourse.database
        }
    }
    // Base de données :
    val database: AppDatabaseCourse = Room
        .databaseBuilder(context.applicationContext, AppDatabaseCourse::class.java, "courses.db")
        .allowMainThreadQueries()
        .build()
}