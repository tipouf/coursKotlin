package com.example.tp2ihm.metier.bdd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp2ihm.metier.dao.CoursesDAO
import com.example.tp2ihm.metier.dto.CourseDTO

@Database(entities = [CourseDTO::class], version = 1)
abstract class AppDatabaseCourse : RoomDatabase()
{
    abstract fun coursesDAO(): CoursesDAO
}