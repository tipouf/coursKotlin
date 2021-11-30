package com.example.tp2ihm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp2ihm.R
import com.example.tp2ihm.adapter.CourseAdapter
import com.example.tp2ihm.databinding.ActivityDataBindingBinding
import com.example.tp2ihm.databinding.ActivityViewModelLiveDataBinding
import com.example.tp2ihm.metier.dto.CourseDTO
import com.example.tp2ihm.viewModels.ListeCourseViewModel
import kotlin.random.Random

class ViewModelLiveData : AppCompatActivity()
{

    private lateinit var activityListBinding: ActivityViewModelLiveDataBinding
    private lateinit var listeCourseViewModel: ListeCourseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_model_live_data)

        // à ajouter pour de meilleures performances
        activityListBinding.listeCourse.setHasFixedSize(true)

        // layout manager :
        activityListBinding.listeCourse.layoutManager = LinearLayoutManager(this)

        // view model:
        listeCourseViewModel = ViewModelProvider(this).get(ListeCourseViewModel::class.java)

        //tableau
//        val listeCourseDTO: MutableList<CourseDTO> = ArrayList()
//        for (a in 1..30)
//        {
//            listeCourseDTO.add(CourseDTO(a.toLong(), "nom $a", Random.nextBoolean(), "divers", a.toFloat()))
//        }

        //adapter :
        val courseAdapter = CourseAdapter(listeCourseViewModel)
        activityListBinding.listeCourse.adapter = courseAdapter

        //observe :
        listeCourseViewModel.liveDataListCourse.observe(this, {
            courseAdapter.updateCourses(it.toMutableList())
        })

        //Chargement :
        listeCourseViewModel.chargerCourses(this)

        //Listerner ajout course:
        activityListBinding.buttonValider.setOnClickListener(){
            listeCourseViewModel.ajoutCourse(activityListBinding.addCourse.text.toString(), this)
        }

    }
}