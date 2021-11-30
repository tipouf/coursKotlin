package com.example.tp2ihm.metier.dao

import androidx.room.*
import com.example.tp2ihm.metier.dto.CourseDTO

@Dao
abstract class CoursesDAO {
    @Query("SELECT * FROM courses ORDER BY intitule ASC")
    abstract fun getListeCourses(): MutableList<CourseDTO>

    @Query("SELECT COUNT(*) FROM courses WHERE intitule = :intitule")
    abstract fun countCourseParTitle(intitule: String): Long

    @Insert
    abstract fun insert(vararg courses: CourseDTO)

    @Update
    abstract fun update(vararg courses: CourseDTO)

    @Delete
    abstract fun delete(vararg courses: CourseDTO)
}