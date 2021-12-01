package com.example.tp2ihm.viewModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp2ihm.metier.bdd.AppDatabaseHelperCourse
import com.example.tp2ihm.metier.dto.CourseDTO
import kotlin.random.Random

class ListeCourseViewModel : ViewModel()
{

    val liveDataListCourse = MutableLiveData<MutableList<CourseDTO>>()

    fun clicCourse(context: Context, courseDTO: CourseDTO)
    {
        Toast.makeText(context, courseDTO.toString(), Toast.LENGTH_LONG).show()
    }

    fun chargerCourses(context: Context)
    {
        liveDataListCourse.value = AppDatabaseHelperCourse.getDatabase(context)
            .coursesDAO()
            .getListeCourses()
    }

    fun ajoutCourse(saisie: String, context: Context)
    {
        val courseDTO = CourseDTO(0,saisie, false,"Divers", 02F)

        AppDatabaseHelperCourse.getDatabase(context).coursesDAO().insert(courseDTO)

        chargerCourses(context)
    }

    fun removeCourse( context: Context, courseDTO: CourseDTO)
    {
        AppDatabaseHelperCourse.getDatabase(context).coursesDAO().delete(courseDTO)
        chargerCourses(context)
    }

    fun updateCourse( context: Context, courseDTO: CourseDTO)
    {
//        val course = CourseDTO(courseDTO.courseId,courseDTO.intitule, !courseDTO.achete, courseDTO.categorie, courseDTO.prix)

        courseDTO.achete = !courseDTO.achete

        AppDatabaseHelperCourse.getDatabase(context).coursesDAO().update(courseDTO)
        chargerCourses(context)
    }
}